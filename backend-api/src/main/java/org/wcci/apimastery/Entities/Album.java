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

    @OneToMany(mappedBy = "album")
    private Collection<Song> songs;



    public String getAlbumName() {
        return albumName;
    }

    public String getImg() {
        return img;
    }

    public Collection<Song> getSongs() {
        return songs;
    }

    private Album(){
    }

    public Album(String albumName, String img, Song...songs) {
        this.albumName = albumName;
        this.img = img;
        this.songs = Arrays.asList(songs);
    }


    public long getId() {
        return id;
    }


}