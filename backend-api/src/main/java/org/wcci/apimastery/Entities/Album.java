package org.wcci.apimastery.Entities;


import javax.persistence.*;
import java.util.Arrays;
import java.util.Collection;
import org.wcci.apimastery.Repositories.SongRepository;

@Entity
public class Album {
    @Id
    @GeneratedValue

    private long id;
    private String albumName;
    private String img;
    private String recordLabel;
    private String comments;
    private int rating;

    @OneToMany(mappedBy = "album")
    private Collection<Song> songs;

    public Album(String albumName, String img, String recordLabel, String comments, int rating, Song... songs) {
        this.albumName = albumName;
        this.img = img;
        this.recordLabel = recordLabel;
        this.comments = comments;
        this.rating = rating;
        this.songs = Arrays.asList(songs);
    }
    private Album(){
    }

    public String getAlbumName() {
        return albumName;
    }

    public String getImg() {
        return img;
    }

    public Collection<Song> getSongs() {
        return songs;
    }

    public String getRecordLabel() {
        return recordLabel;
    }

    public String getComments() {
        return comments;
    }

    public int getRating() {
        return rating;
    }

    public long getId() {
        return id;
    }


}