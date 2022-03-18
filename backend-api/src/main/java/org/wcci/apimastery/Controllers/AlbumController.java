package org.wcci.apimastery.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.wcci.apimastery.Entities.Album;
import org.wcci.apimastery.Entities.Artist;
import org.wcci.apimastery.Repositories.AlbumRepository;
import org.wcci.apimastery.Repositories.ArtistRepository;
import org.wcci.apimastery.Repositories.SongRepository;

import java.util.Optional;

@RestController
public class AlbumController {
    private AlbumRepository albumRepo;
    private SongRepository songRepo;
    private ArtistRepository artistRepo;


    public AlbumController(AlbumRepository albumRepo, SongRepository songRepo, ArtistRepository artistRepo) {
        this.albumRepo = albumRepo;
        this.songRepo = songRepo;
        this.artistRepo = artistRepo;
    }

    @GetMapping("/albums")
    public Iterable<Album> getAlbums() {
        return albumRepo.findAll();
    }
    @GetMapping("/albums/{id}")
    public Album getAlbum(@PathVariable long id) {
        return albumRepo.findById(id).get();
    }
    

}