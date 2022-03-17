package org.wcci.apimastery.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.wcci.apimastery.Entities.Song;
import org.wcci.apimastery.Repositories.AlbumRepository;
import org.wcci.apimastery.Repositories.ArtistRepository;
import org.wcci.apimastery.Repositories.SongRepository;


import java.util.Optional;

@Controller
public class SongController {
    private ArtistRepository artistRepo;
    private SongRepository songRepo;
    private AlbumRepository albumRepo;

    public SongController(ArtistRepository artistRepo, SongRepository songRepo, AlbumRepository albumRepo) {
        this.artistRepo = artistRepo;
        this.songRepo = songRepo;
        this.albumRepo = albumRepo;
    }

    @GetMapping("/songs")
    public String showSongsTemplate(Model model) {
        model.addAttribute("songs", songRepo.findAll());
        model.addAttribute("filterName", "All Songs");
        return "SongsTemplate";
    }

    @GetMapping("/song/{id}")
    public String showSongTemplate(Model model, @PathVariable long id) {
        Optional<Song> tempSong = songRepo.findById(id);
        if (tempSong.isPresent()) {
            model.addAttribute("artists", tempSong.get().getSongs());
            model.addAttribute("filterName", tempSong.get().getSongName());
            return "ArtistsTemplate";
        }

        return null;
    }
}
