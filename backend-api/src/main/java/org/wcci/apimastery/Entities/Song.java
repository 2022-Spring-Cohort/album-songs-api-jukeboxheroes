package org.wcci.apimastery.Entities;


import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Objects;

@Entity
public class Song {
    @Id
    @GeneratedValue

    private long id;
    private String name;
    private String duration;
    private int rating;

    @ManyToOne
    @JsonIgnore
    private Album album;
    @ElementCollection
    private List<Comment> comments;


    public Song(String name, String duration, int rating, Album album) {
        this.name = name;
        this.duration = duration;
        this.rating = rating;
        this.album = album;
    }

    public Song(){
    }

    public void addComment(Comment newComment) {
        if (comments == null) {
            comments = new ArrayList<>();
        }
        comments.add(newComment);
    }
    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Album getAlbum() {
        return album;
    }

    public void addSong(String songName) {
        this.name = songName;
    }

    public String getDuration() {
        return duration;
    }


    public int getRating() {
        return rating;
    }

    public void setAlbum(Album album) {
        this.album = album;
    }
    public Collection<Comment> getComments() {
        return comments;
    }
}