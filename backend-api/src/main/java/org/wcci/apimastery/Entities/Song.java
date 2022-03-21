package org.wcci.apimastery.Entities;


import javax.persistence.*;
import java.security.PrivateKey;
import java.util.Arrays;
import java.util.Collection;

@Entity
public class Song {
    @Id
    @GeneratedValue

    private long id;
    private String songName;
    private String duration;
    private String comments;
    private int rating;


    @ManyToOne
    private Album album;

    @ManyToOne
    private Artist artist;


    public Song(String songName, String duration, String comments, int rating, Artist artist) {
        this.songName = songName;
        this.duration = duration;
        this.comments = comments;
        this.rating = rating;
        this.album = album;
        this.artist = artist;
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

    public String getDuration() {
        return duration;
    }

    public String getComments() {
        return comments;
    }

    public int getRating() {
        return rating;
    }

    public Artist getArtist() {
        return artist;
    }

    public void setAlbum(Album album) {
        this.album = album;
    }
}