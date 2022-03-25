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
        Album album1 = new Album("4","Foreigner", "images/Foreigner4.jpg","2002 Atlantic Recording Corp.",5);
        album1.addComment(new Comment("Dallas favorite song.",2));
        albumRepo.save(album1);
        Song JukeBoxHero = new Song("Juke Box Hero", "4:19", 5, album1, "https://open.spotify.com/embed/track/00qOE7OjRl0BpYiCiweZB2?utm_source=generator" );
        JukeBoxHero.addComment(new Comment("Dallas is the stuff to this song",3));
        songRepo.save(JukeBoxHero);




        Album album2 = new Album("Thriller","Michael Jackson", "images/MJThriller.png"," 1982, 2001, 2008 MJJ Productions Inc.",  5);
        album2.addComment(new Comment("Ben's Life is this album",1));
        albumRepo.save(album2);
        Song BillieJean = new Song("BillieJean", "4:15",2, album2,"https://open.spotify.com/embed/track/3S2R0EVwBSAVMd5UMgKTL0?utm_source=generator");
        BillieJean.addComment(new Comment("Ben is the stuff to this song.",5));
        songRepo.save(BillieJean);


        Album album3 = new Album("Starboy","The Weeknd","images/Starboy.jpg", " 2016 The Weeknd XO, Inc., Manufactured and Marketed by Republic Records, a Division of UMG Recordings, Inc.", 5);
        album3.addComment(new Comment("Adnan's Life is this album",1));
        albumRepo.save(album3);
        Song Starboy = new Song("Starboy", "3:15", 1,album3,"https://open.spotify.com/embed/track/7MXVkk9YMctZqd1Srtv4MB?utm_source=generator");
        Starboy.addComment(new Comment("Adnan is the stuff to this song.",4));
        songRepo.save(Starboy);


        Album album4 = new Album("My Prerogative", "Britney Spears","images/Brittany.jpg", "This compilation (P) 2004 Zomba Recording LLC",5);
        album4.addComment(new Comment("Brian's life is this comment",4));
        albumRepo.save(album4);
        Song doSomethin = new Song("Do Somethin","3:24",2,album4,"https://open.spotify.com/embed/track/01ACsk2knUnsfWeZp63nqa?utm_source=generator");
        doSomethin.addComment(new Comment("Brian is a Britney fan!",3));
        songRepo.save(doSomethin);


        Album album5 = new Album("Out of the Blue", "ELO","images/MrBlueSky.jpg", " 1972, 1977, 1978Epic Records, a divsion of Sony Music Entertainment",5);
        album5.addComment(new Comment("David's Life is this album",5));
        albumRepo.save(album5);
        Song mrBlueSky = new Song("Mr. Blue Sky", "5:03", 5,album5,"https://open.spotify.com/embed/track/2RlgNHKcydI9sayD2Df2xp?utm_source=generator");
        mrBlueSky.addComment(new Comment("Rocked on the Guardians of the Galaxy movie!",4));
        songRepo.save(mrBlueSky);


        Album album6 = new Album("A Night at the Opera", "Queen","images/Queen.jpg", "2006 Hollywood Records, Inc.", 5);
        album6.addComment(new Comment("Ricky's Life is this album",2));
        albumRepo.save(album6);
        Song bohemianRhapsody = new Song("Bohemian Rhapsody", "5:54", 5, album6,"https://open.spotify.com/embed/track/6l8GvAyoUZwWDgF1e4822w?utm_source=generator");
        bohemianRhapsody.addComment(new Comment("Rocked on the Queen official movie!",1));
        songRepo.save(bohemianRhapsody);

    }
}