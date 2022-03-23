package org.wcci.apimastery;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.wcci.apimastery.Entities.Album;
import org.wcci.apimastery.Entities.Comment;
import org.wcci.apimastery.Entities.Song;
import org.wcci.apimastery.Repositories.AlbumRepository;
import org.wcci.apimastery.Repositories.SongRepository;

@Component
public class Populator implements CommandLineRunner {
    @Autowired
    AlbumRepository albumRepo;
    @Autowired
    SongRepository songRepo;


    @Override
    public void run(String... args) throws Exception {
        Album album1 = new Album("4","Foreigner", "images/Foreigner4.jpg","Atlantic Records",5);
        album1.addComment(new Comment("Dallas favorite song"));
        albumRepo.save(album1);
        Song JukeBoxHero = new Song("Juke Box Hero", "4:19", 5, album1 );
        JukeBoxHero.addComment(new Comment("Dallas stole this project name from the teach."));
        songRepo.save(JukeBoxHero);



        Album album2 = new Album("Thriller","Michael Jackson", "images/MJThriller.png","Atlantic Records",  5);
        album2.addComment(new Comment("Adnan's Life is this album"));
        albumRepo.save(album2);
        Song BillieJean = new Song("BillieJean", "4:15",2, album2);
        BillieJean.addComment(new Comment("comment"));
        songRepo.save(BillieJean);


        Album album3 = new Album("Starboy","The Weeknd","images/Starboy.jpg", "Republican Records", 5);
        album3.addComment(new Comment("Ryan's Life is this album"));
        albumRepo.save(album3);
        Song Starboy = new Song("Starboy", "3:15", 1,album3);
        Starboy.addComment(new Comment("comment."));
        songRepo.save(Starboy);


        Album album4 = new Album("My Prerogative", "Bon Jovi","images/Brittany.jpg", "Zomba Records",5);
        album4.addComment(new Comment("comment"));
        albumRepo.save(album4);
        Song doSomethin = new Song("Do Somethin","3:24",2,album4);
        doSomethin.addComment(new Comment("Never really Heard it!"));
        songRepo.save(doSomethin);


        Album album5 = new Album("Out of the Blue", "ELO","images/MrBlueSky.jpg", "Epic Records",5);
        album5.addComment(new Comment("David's Life is this album"));
        albumRepo.save(album5);
        Song mrBlueSky = new Song("Mr. Blue Sky", "5:03", 5,album5);
        mrBlueSky.addComment(new Comment("Rocked on the Guardians of the Galaxy movie!"));
        songRepo.save(mrBlueSky);


        Album album6 = new Album("A Night at the Opera", "Queen","images/Queen.jpg", "Hollywood Records", 5);
        album6.addComment(new Comment("Ricky's Life is this album"));
        albumRepo.save(album6);
        Song bohemianRhapsody = new Song("Bohemian Rhapsody", "5:54", 5, album6);
        bohemianRhapsody.addComment(new Comment("Rocked on the Queen official movie!"));
        songRepo.save(bohemianRhapsody);

    }
}