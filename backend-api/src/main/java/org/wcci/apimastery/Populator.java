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

        Artist Foreigner = new Artist("Foreigner");
        artistRepo.save(Foreigner);
        Song JukeBoxHero = new Song("Juke Box Hero", "4:19","Stars in his eyes", 5, Foreigner );
        songRepo.save(JukeBoxHero);
        Album album1 = new Album("4","","Atlantic Records","Best album eva",5,JukeBoxHero);
        albumRepo.save(album1);

        Artist michaelJackson = new Artist("Michael Jackson");
        artistRepo.save(michaelJackson);
        Song BillieJean = new Song("BillieJean", "4:15","Itsa greeat!", 5,michaelJackson);
        songRepo.save(BillieJean);
        Album album2 = new Album("Thriller","","Atlantic Records", "Itsa greaat!", 5, BillieJean);
        albumRepo.save(album2);

        Artist theWeekend = new Artist("The Weekend");
        artistRepo.save(theWeekend);
        Song Starboy = new Song("Starboy", "3:15", "Adnan is the __ Starboy",5, theWeekend);
        songRepo.save(Starboy);
        Album album3 = new Album("Starboy","", "Republican Records","#starfish", 5, Starboy);
        albumRepo.save(album3);

        Artist brittanySpears = new Artist("Brittany Spears");
        artistRepo.save(brittanySpears);
        Song doSomethin = new Song("Do Somethin","3:24","Brian says leave Brittany alone!",5, brittanySpears);
        songRepo.save(doSomethin);
        Album album4 = new Album("My Prerogative", "", "Zomba Records","Its Brian's prerogative",5, doSomethin);
        albumRepo.save(album4);

        Artist electricLightOrchestra = new Artist("Electric Light Orchestra");
        artistRepo.save(electricLightOrchestra);
        Song mrBlueSky = new Song("Mr. Blue Sky", "5:03", "Guardians of the Galaxy Theme song",5, electricLightOrchestra);
        songRepo.save(mrBlueSky);
        Album album5 = new Album("Out of the Blue", "", "Epic Records", "Baby Groots fave album",5,mrBlueSky);
        albumRepo.save(album5);

        Artist Queen = new Artist("Queen");
        artistRepo.save(Queen);
        Song bohemianRhapsody = new Song("Bohemian Rhapsody", "5:54", "Righteous", 5,Queen);
        songRepo.save(bohemianRhapsody);
        Album album6 = new Album("A Night at the Opera", "", "Hollywood Records","We're not worthy", 5, bohemianRhapsody);
        albumRepo.save(album6);



    }
}