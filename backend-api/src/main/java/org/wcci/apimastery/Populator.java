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
        Song song2 = new Song("Juke Box Hero", artist, MichaelJacksonHits);

        songRepo.save(song1);
        songRepo.save(song2);
        Album album1 = new Album("TerminatorSoundTrack","resources/TheTerminator.jpg",song1);
        Album album2 = new Album("4","",song2);
        Album album3 = new Album("The Marshall Mathers LP2","",song2);
        Album album4 = new Album("Led Zeppelin I", "", song1);
        Album album5 = new Album("Led Zeppelin II", "", song1);
        Album album6 = new Album("Led Zeppelin III", "", song1);
        Album album7 = new Album("Led Zeppelin IV", "", song1);
        Album album8 = new Album("Coda", "", song1);
        Album album9 = new Album("Presence", "", song1);
        Album album10 = new Album("Mothership", "", song1);
        Album album11 = new Album("In Through The Out Door", "", song1);
        Album album12 = new Album("Houses of The Holy", "", song1);
        Album album13 = new Album("Physical Graffiti", "", song1);

        albumRepo.save(album1);
        albumRepo.save(album2);
        albumRepo.save(album3);
        albumRepo.save(album4);
        albumRepo.save(album5);
        albumRepo.save(album6);
        albumRepo.save(album7);
        albumRepo.save(album8);
        albumRepo.save(album9);
        albumRepo.save(album10);
        albumRepo.save(album11);
        albumRepo.save(album12);
        albumRepo.save(album13);


    }
}