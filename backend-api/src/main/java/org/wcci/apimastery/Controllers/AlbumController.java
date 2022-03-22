package org.wcci.apimastery.Controllers;

import org.springframework.web.bind.annotation.*;
import org.wcci.apimastery.Entities.Album;
import org.wcci.apimastery.Entities.Comment;
import org.wcci.apimastery.Entities.Song;
import org.wcci.apimastery.Repositories.AlbumRepository;
import org.wcci.apimastery.Repositories.SongRepository;

@RestController
public class AlbumController {
    private AlbumRepository albumRepo;
    private SongRepository songRepo;



    public AlbumController(AlbumRepository albumRepo, SongRepository songRepo) {
        this.albumRepo = albumRepo;
        this.songRepo = songRepo;
    }

    @GetMapping("/albums")
    public Iterable<Album> getAlbums() {
        return albumRepo.findAll();
    }

    @GetMapping("/albums/{id}")
    public Album getAlbum(@PathVariable long id) {
        return albumRepo.findById(id).get();
    }

    @PostMapping("/albums/{id}/addSong")
    public Album addSongToAlbum(@PathVariable long id, @RequestBody Song song){
        Album album = albumRepo.findById(id).get();
        song.setAlbum(album);
        songRepo.save(song);
        return album;
    }
    @DeleteMapping("/albums/{id}")
    public Iterable<Album> deleteAlbum(@PathVariable long id)
    {
        albumRepo.delete(albumRepo.findById(id).get());
        return  albumRepo.findAll();
    }

    @PostMapping("/albums/addAlbum")
    public Iterable<Album> addAlbums(@RequestBody Album album){
        albumRepo.save(album);
        return albumRepo.findAll();
    }
    @PatchMapping("/albums/{id}")
    public Iterable<Album> changeAlbumTitle(@PathVariable long id, @RequestBody String title)
    {
        Album album = albumRepo.findById(id).get();
        album.updateTitle(title);
        albumRepo.save(album);
        return  albumRepo.findAll();
    }


}