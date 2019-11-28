package com.playstationbackend.playstationbackend;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class PlaystationbackendApplication {



    public static void main(String[] args) {

        Scrape scrape = new Scrape();
        scrape.doScrape();


        SpringApplication.run(PlaystationbackendApplication.class, args);

    }

}
