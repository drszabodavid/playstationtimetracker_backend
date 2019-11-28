package com.playstationbackend.playstationbackend;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Scrape {

    public void doScrape(){

        try {
            // Here we create a document object and use JSoup to fetch the website
            Document doc = Jsoup.connect("https://psnprofiles.com/szikora52665").get();

            // With the document fetched, we use JSoup's title() method to fetch the title
            System.out.printf("Title: %s\n", doc.title());

            Elements repositories = doc.getElementsByClass("ellipsis");

            List<String> titles = new ArrayList<>();

            for (Element repository : repositories) {
                // Extract the title

                String repositoryTitle = repository.getElementsByClass("title").text();

                titles.add(repositoryTitle);


                // Format and print the information to the console
                System.out.println("-----------------------------");
                System.out.println(titles);

                System.out.println("\n");
            }

            // In case of any IO errors, we want the messages written to the console
        } catch (
                IOException e) {
            e.printStackTrace();
        }
    }


}
