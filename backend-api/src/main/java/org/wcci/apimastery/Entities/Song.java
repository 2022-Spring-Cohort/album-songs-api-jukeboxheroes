package org.wcci.apimastery.Entities;


import javax.persistence.*;
import java.util.Collection;

@Entity
public class Song {
    @Id
    @GeneratedValue

    private long id;
    private String songName;
    private String album;

    @ManyToOne
    private Collection<Album> albums;

    private Collection<Song> songs;

    public Song(String songName,Album... albums) {
        this.id = id;
        this.songName = songName;
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

    public String getAlbum() {
        return album;
    }

    public Collection<Song> getSongs() {
        return songs;
    }

    public void addSong(String songName) {
        this.songName = songName;
    }

}