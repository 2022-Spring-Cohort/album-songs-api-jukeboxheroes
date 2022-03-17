package org.wcci.apimastery;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.wcci.apimastery.Entities.Album;
import org.wcci.apimastery.Entities.Artist;
import org.wcci.apimastery.Entities.Song;
import org.wcci.apimastery.Repositories.AlbumRepository;
import org.wcci.apimastery.Repositories.ArtistRepository;
import org.wcci.apimastery.Repositories.SongRepository;

import java.util.Collection;

@Component
public class Populator implements CommandLineRunner {
    @Autowired
    AlbumRepository albumRepo;
    @Autowired
    SongRepository songRepo;
    @Autowired
    ArtistRepository artistRepo;


    @Override
    public void run(String... args) throws Exception {
        Artist artist = new Artist("Michael Jackson");
        artistRepo.save(artist);
        Album MichaelJacksonHits = null;
        Song song1 = new Song("BillieJean", artist, MichaelJacksonHits);
        songRepo.save(song1);
        Album album1 = new Album("TerminatorSoundTrack","resources/TheTerminator.jpg",song1);
        albumRepo.save(album1);


    }
}