package com.playstationbackend.playstationbackend.init;

import com.playstationbackend.playstationbackend.entity.Game;
import com.playstationbackend.playstationbackend.entity.User;
import com.playstationbackend.playstationbackend.repository.GameRepository;
import com.playstationbackend.playstationbackend.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;

@Component
public class DataInit implements ApplicationRunner {

    private PersonRepository personRepository;
    private GameRepository gameRepository;

    private static final DateFormat df = new SimpleDateFormat("yyyy-MM-dd");

    @Autowired
    public DataInit(PersonRepository personRepository, GameRepository gameRepository) {
        this.personRepository = personRepository;
        this.gameRepository = gameRepository;
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        long count = personRepository.count();
        long countGames = gameRepository.count();

        if (countGames == 0){
            Game game = new Game();
            game.setGameplayCompletionist(91);
            game.setGameplayMain(35);
            game.setGameplayMainExtra(62);
            game.setImageUrl("https://howlongtobeat.com/gameimages/36936_Nioh.jpg");
            game.setName("Nioh");
            game.setLiked(true);
            game.setCompleted(false);
            game.setTimeSpent(3);
            game.setId("333");
            game.setRemainingTime(3);

            gameRepository.save(game);

            Game game2 = new Game();
            game2.setGameplayCompletionist(91);
            game2.setGameplayMain(35);
            game2.setGameplayMainExtra(62);
            game2.setId("222");
            game2.setImageUrl("https://howlongtobeat.com/gameimages/36936_Nioh.jpg");
            game2.setName("Nioh");
            game2.setLiked(true);
            game2.setCompleted(false);
            game2.setTimeSpent(3);
            game2.setRemainingTime(3);

            gameRepository.save(game2);

            List<Game> a = new ArrayList<Game>();
            a.add(game);
            a.add(game2);

            User p1 = new User();

            p1.setName("John");
            p1.setEmail("john@gmail.com");
            p1.setPassword(1234);
            p1.setGames(a);

            //
            User p2 = new User();

            p2.setName("Smith");
            p2.setEmail("smith@gmail.com");
            p2.setPassword(1234);
            p2.setGames(a);

            personRepository.save(p1);
            personRepository.save(p2);

        }





    }
}
