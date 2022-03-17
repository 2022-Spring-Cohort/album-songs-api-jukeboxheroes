package org.wcci.apimastery.Entities;


import javax.persistence.*;
import java.util.Arrays;
import java.util.Collection;
import org.wcci.apimastery.Repositories.SongRepository;
import org.wcci.apimastery.Repositories.AlbumRepository;

@Entity
public class Artist {
    @Id
    @GeneratedValue

    private long Id;
    private String name;

    @OneToMany(mappedBy = "artist")
    private Collection<Song> songs;

    public Artist(String name) {
        this.name = name;
    }

    public Artist(){

    }

    public long getId() {
        return Id;
    }

    public String getName() {
        return name;
    }


    public Collection<Song> getSongs() {
        return songs;
    }
}