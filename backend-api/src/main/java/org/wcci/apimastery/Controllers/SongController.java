package org.wcci.apimastery.Controllers;

import org.springframework.web.bind.annotation.*;
import org.wcci.apimastery.Entities.Album;
import org.wcci.apimastery.Entities.Comment;
import org.wcci.apimastery.Entities.Song;
import org.wcci.apimastery.Repositories.AlbumRepository;
import org.wcci.apimastery.Repositories.SongRepository;

import java.awt.print.Book;

@RestController
public class SongController {
    private SongRepository songRepo;
    private AlbumRepository albumRepo;

    public SongController(SongRepository songRepo, AlbumRepository albumRepo) {
        this.songRepo = songRepo;
        this.albumRepo = albumRepo;
    }

    @GetMapping("/songs")
    public Iterable<Song> getSongs(){
        return songRepo.findAll();
    }

    @GetMapping("/songs/{id}")
    public Song getSong(@PathVariable long id){
        return songRepo.findById(id).get();
    }
    @DeleteMapping("/songs/{id}")
    public Iterable<Song> deleteBook(@PathVariable long id)
    {
        songRepo.delete(songRepo.findById(id).get());
        return songRepo.findAll();
    }

    @PatchMapping("/songs/{id}")
    public Iterable<Song> updateName(@PathVariable long id, @RequestBody String name)
    {
        Song song = songRepo.findById(id).get();
        song.updateName(name);
        songRepo.save(song);
        return  songRepo.findAll();
    }
    @PostMapping("/songs/{id}/addSongComment")
    public Iterable<Song> addCommentToSong(@PathVariable long id, @RequestBody Comment comment){
        Song song = songRepo.findById(id).get();
        song.addComment(comment);
        songRepo.save(song);
        return songRepo.findAll();
    }

}