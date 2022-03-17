package org.wcci.apimastery.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.wcci.apimastery.Entities.Artist;
import org.wcci.apimastery.Repositories.AlbumRepository;
import org.wcci.apimastery.Repositories.ArtistRepository;
import org.wcci.apimastery.Repositories.SongRepository;
import java.util.Optional;

@Controller
public class AlbumController {
    private AlbumRepository albumRepo;
    private SongRepository songRepo;
    private ArtistRepository artistRepo;


    public AlbumController(AlbumRepository albumRepo, SongRepository songRepo, ArtistRepository artistRepo) {
        this.albumRepo = albumRepo;
        this.songRepo = songRepo;
        this.artistRepo = artistRepo;
    }

    @GetMapping("/")
    public String showIndexTemplate(Model model) {
        model.addAttribute("albums", albumRepo.findAll());
        return "indexTemplate";
    }

    @GetMapping("/artists")
    public String showArtistsTemplate(Model model) {
        model.addAttribute("artists", artistRepo.findAll());
        model.addAttribute("filterName", "All Artists");
        return "ArtistsTemplate";
    }

    @GetMapping("/artists/{id}")
    public String showConsoleTemplate(Model model, @PathVariable long id) {
        Optional<Artist> tempArtist = artistRepo.findById(id);
        if (tempArtist.isPresent()) {
            model.addAttribute("inArtist", tempArtist.get());
        }
        return "ArtistTemplate";
    }

    @GetMapping("/artists/name/{name}")
    public String showArtistByName(Model model, @PathVariable String name) {
        Optional<Artist> tempArtist = artistRepo.findByNameIgnoreCase(name);
        if (tempArtist.isPresent()) {
            model.addAttribute("inArtist", tempArtist.get());
        }
        return "ArtistsTemplate";
    }
    //    @RequestMapping(params = "song", value="/artist/{id}", method = RequestMethod.POST)
//    public String addSongToArtist(@PathVariable long id, @RequestParam String songName) {
//        Optional<Artist> tempArtist = tempArtist.findById(id);
//        Optional<Song> songToAdd = songRepo.findBySongNameIgnoreCase(songName);
//        if (tempArtist.isPresent()) {
//            Song tempSong;
//            if(songToAdd.isPresent()){
//                tempSong = songToAdd.get();
//            }
//            else
//            {
//                tempSong = new Song(songName);
//            }
//            tempSong.addSong(tempSong.getSongName());
//            songRepo.save(tempSong);
//        }
//        return "redirect:/console/" + id;
//    }
//    @RequestMapping(params = "song", method = RequestMethod.POST, value="/console/{id}")
//    public String addSongToAtrist(@PathVariable long id, @RequestParam String songName, @RequestParam String artistName) {
//        Optional<Artist> tempArtist = artistRepo.findById(id);
//        if (tempArtist.isPresent()) {
//            Song tempReview = new Review(name, review, tempConsole.get());
//            reviewRepo.save(tempReview);
//        }
//        return "redirect:/console/" + id;
//    }
//    @RequestMapping(value="/console/{id}", method = RequestMethod.POST, params = "hashtag")
//    public String addHashtagToConsole(@PathVariable long id, @RequestParam String hashtag) {
//        Optional<Console> tempConsole = consoleRepo.findById(id);
//        if (tempConsole.isPresent()) {
//            Hashtag tempHashtag = new Hashtag(hashtag, tempConsole.get());
//            hashtagRepo.save(tempHashtag);
//        }

//        return "redirect:/console/" + id;
//    }

}