package org.wcci.apimastery.Entites;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.Arrays;
import java.util.Collection;

@Entity
public class Album {
    @Id
    @GeneratedValue

    private long Id;
    private String album;
    @OneToMany(mappedBy = "Album")




    public Album(long Id, String album, Song ...songs) {
        this.Id = Id;
        this.album = album;
        this.songs = Arrays.asList();
    }

    public Album(){
    }

    public long getId() {
        return Id;
    }

    public String getAlbum() {
        return album;
    }


}