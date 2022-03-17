package org.wcci.apimastery.Entities;


import javax.persistence.*;
import java.util.Arrays;
import java.util.Collection;
import org.wcci.apimastery.Repositories.SongRepository;

@Entity
public class Album {
    @Id
    @GeneratedValue

    private long Id;
    private String albumName;

    @ManyToOne
    @JoinColumn(name = "songs_id")
    private Song songs;

    public Song getSongs() {
        return songs;
    }

    public String getAlbumName() {
        return albumName;
    }
    private Album(){
    }

    public Album(String albumName, Song...songs) {
        this.albumName = albumName;
        this.songs = (Song) Arrays.asList(songs);
    }


    public long getId() {
        return Id;
    }


}