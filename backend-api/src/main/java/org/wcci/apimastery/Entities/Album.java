package org.wcci.apimastery.Entities;


import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Entity
public class Album {
    @Id
    @GeneratedValue

    private long id;
    private String title;
    private String img;
    private String recordLabel;
    private int averageRating;
    private String artistName;
    @OneToMany(mappedBy = "album", cascade = CascadeType.ALL, orphanRemoval = true)
    private Collection<Song> songs;
    @ElementCollection
    private List<Comment> comments;

    public Album(String title,String artistName, String img, String recordLabel, int averageRating) {
        this.title = title;
        this.artistName = artistName;
        this.img = img;
        this.recordLabel = recordLabel;
        this.averageRating = averageRating;
        comments = new ArrayList<>();
    }

    private Album(){
    }

    public String getArtistName() {
        return artistName;
    }

    public String getTitle() {
        return title;
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

    public List<Comment> getComments() {
        return comments;
    }

    public void addAlbum(String title) {
        this.title = title;
    }

    public int getAverageRating() {
        return averageRating;
    }

    public long getId() {
        return id;
    }

    public void addComment(Comment newComment) {
        comments.add(newComment);
        computeAverageRating();
    }

    public void computeAverageRating(){
        float sum = 5;
        for(Comment currentComment: comments){
            sum += currentComment.getRating();
        }
        averageRating = Math.round(sum/(comments.size()+1));
    }

    public void updateTitle(String newTitle) {
        title = newTitle;
    }
}