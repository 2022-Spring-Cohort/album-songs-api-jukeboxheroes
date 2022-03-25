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
    private String video;
    @ElementCollection
    private List<Comment> comments;


    public Song(String name, String duration, int rating, Album album, String video) {
        this.name = name;
        this.duration = duration;
        this.rating = rating;
        this.album = album;
        this.video = video;
    }


    public Song(){
    }

    public void addComment(Comment comment) {
        if (comments == null) {
            comments = new ArrayList<>();
        }
        comments.add(comment);
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

    public String getVideo() {
        return video;
    }

    public int getRating() {
        computeAverageRating();

        return rating;
    }
    public void computeAverageRating(){
        float sum = 0;
        if(comments.size()>0) {
            for (Comment currentComment : comments) {
                sum += currentComment.getRating();
            }
            rating = Math.round(sum / (comments.size() ));
            System.out.println(rating);
        }
    }
    public void setAlbum(Album album) {
        this.album = album;
    }
    public Collection<Comment> getComments() {
        return comments;
    }

    public void updateName(String name) {
        this.name = name;
    }
}