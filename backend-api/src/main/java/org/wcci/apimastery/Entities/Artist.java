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

    @OneToMany
    private Collection<Artist> artist;

    @ManyToOne
    private Collection<Song> songs;
}