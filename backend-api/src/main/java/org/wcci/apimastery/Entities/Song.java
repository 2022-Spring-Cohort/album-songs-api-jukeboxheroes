package org.wcci.apimastery.Entities;


import javax.persistence.*;
import java.util.Arrays;
import java.util.Collection;

@Entity
public class Song {
    @Id
    @GeneratedValue

    private long id;
    private String songName;


    @ManyToOne
    private Album album;

    @ManyToOne
    private Artist artist;


    public Song(String songName,Artist artist, Album album) {
        this.songName = songName;
        this.artist = artist;
        this.album = album;

    }
    public Song(){

    }

    public long getId() {
        return id;
    }

    public String getSongName() {
        return songName;
    }

    public Album getAlbum() {
        return album;
    }

//    public Collection<Song> getSongs() {
//        return songs;
//    }

    public void addSong(String songName) {
        this.songName = songName;
    }

}