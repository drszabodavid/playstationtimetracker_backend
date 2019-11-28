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
import java.util.Date;

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

        if (count == 0) {
            User p1 = new User();

            p1.setName("John");

            p1.setEmail("john@gmail.com");
            p1.setPassword(1234);
            //
            User p2 = new User();

            p2.setName("Smith");
            p2.setEmail("smith@gmail.com");
            p2.setPassword(1234);;

            personRepository.save(p1);
            personRepository.save(p2);
        }

        if (countGames == 0){
            Game game = new Game();
            game.setGameplayCompletionist(91);
            game.setGameplayMain(35);
            game.setGameplayMainExtra(62);
            game.setId("36936");
            game.setImageUrl("https://howlongtobeat.com/gameimages/36936_Nioh.jpg");
            game.setName("Nioh");
            game.setLiked(true);
            game.setCompleted(false);
            game.setTimeSpent(3);
            game.setRemainingTime(3);

            gameRepository.save(game);

        }

    }
}
