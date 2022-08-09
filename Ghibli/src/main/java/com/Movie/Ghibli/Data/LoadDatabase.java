package com.Movie.Ghibli.Data;


import org.json.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.Movie.Ghibli.GhibObject.Ghibli;


@Configuration
public class LoadDatabase {
    private static final Logger log = LoggerFactory.getLogger(LoadDatabase.class);

    public static Ghibli newMovie(String form){

        JSONObject data_obj = new JSONObject(form);
        String title = data_obj.getString("title");
        String director = data_obj.getString("director");
        String release_date = data_obj.getString("release_date");
        String running_time = data_obj.getString("running_time");

        return new Ghibli(title,director,release_date,running_time);
    }


    
    @Bean
    CommandLineRunner initDatabase(GhibliRepository repository){

		Loadjson tot = new Loadjson("https://ghibliapi.herokuapp.com/films/58611129-2dbc-4a81-a72f-77ddfc1b1b49");
        Ghibli totoro = newMovie(tot.getJson());
        
        Loadjson cas = new Loadjson("https://ghibliapi.herokuapp.com/films/2baf70d1-42bb-4437-b551-e5fed5a87abe");
        Ghibli castle = newMovie(cas.getJson());
        
        Loadjson gra = new Loadjson("https://ghibliapi.herokuapp.com/films/12cfb892-aac0-4c5b-94af-521852e46d6a");
        Ghibli grave = newMovie(gra.getJson());

        Loadjson ki = new Loadjson("https://ghibliapi.herokuapp.com/films/ea660b10-85c4-4ae3-8a5f-41cea3648e3e");
        Ghibli kiki = newMovie(ki.getJson());

        Loadjson spi = new Loadjson("https://ghibliapi.herokuapp.com/films/dc2e6bd1-8156-4886-adff-b39e6043af0c");
        Ghibli spirited = newMovie(spi.getJson());

        Loadjson ho = new Loadjson("https://ghibliapi.herokuapp.com/films/cd3d059c-09f4-4ff3-8d63-bc765a5184fa");
        Ghibli howl = newMovie(ho.getJson());

        return args -> {
            log.info("Preloading " + repository.save(totoro));
            log.info("Preloading " + repository.save(castle));
            log.info("Preloading " + repository.save(grave));
            log.info("Preloading " + repository.save(kiki));
            log.info("Preloading " + repository.save(spirited));
            log.info("Preloading " + repository.save(howl));
        };
    }
}
