package com.playstationbackend.playstationbackend.init;

import com.playstationbackend.playstationbackend.entity.Game;
import com.playstationbackend.playstationbackend.entity.SelectedGame;
import com.playstationbackend.playstationbackend.entity.User;
import com.playstationbackend.playstationbackend.repository.GameRepository;
import com.playstationbackend.playstationbackend.repository.SelectedGameRepository;
import com.playstationbackend.playstationbackend.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

@Component
public class DataInit implements ApplicationRunner {

    private UserRepository userRepository;
    private GameRepository gameRepository;
    private SelectedGameRepository selectedGameRepository;

    private static final DateFormat df = new SimpleDateFormat("yyyy-MM-dd");

    @Autowired
    public DataInit(UserRepository userRepository, GameRepository gameRepository, SelectedGameRepository selectedGameRepository) {
        this.userRepository = userRepository;
        this.gameRepository = gameRepository;
        this.selectedGameRepository = selectedGameRepository;
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        long count = userRepository.count();
        long countGames = gameRepository.count();

        if (countGames == 0) {
            Game game = new Game();
            game.setGameplayCompletionist(91);
            game.setGameplayMain(35);
            game.setGameplayMainExtra(62);
            game.setImageUrl("https://howlongtobeat.com/gameimages/36936_Nioh.jpg");
            game.setName("Nioh");

            game.setId("333");

            gameRepository.save(game);


            Game game2 = new Game();
            game2.setGameplayCompletionist(200);
            game2.setGameplayMain(200);
            game2.setGameplayMainExtra(200);
            game2.setImageUrl("https://howlongtobeat.com/gameimages/36936_Nioh.jpg");
            game2.setName("Nioh");

            game2.setId("444");

            gameRepository.save(game2);

            User p1 = new User();
            p1.setName("John");
            p1.setEmail("john@gmail.com");
            p1.setPassword(1234);
            userRepository.save(p1);


            User p2 = new User();
            p2.setName("Smith");
            p2.setEmail("smith@gmail.com");
            p2.setPassword(1234);
            userRepository.save(p2);


            SelectedGame selectedGame = new SelectedGame().builder()
                    .gameId("333")
                    .completed(true)
                    .remainingTime(3)
                    .timeSpent(5)
                    .liked(true)
                    .user(p1)
                    .build();

            SelectedGame selectedGame2 = new SelectedGame().builder()
                    .gameId("333")
                    .completed(false)
                    .remainingTime(21233)
                    .timeSpent(5)
                    .liked(false)
                    .user(p2)
                    .build();

            SelectedGame selectedGame3 = new SelectedGame().builder()
                    .gameId("444")
                    .completed(true)
                    .remainingTime(333)
                    .timeSpent(5)
                    .liked(true)
                    .user(p2)
                    .build();



            selectedGameRepository.save(selectedGame);
            selectedGameRepository.save(selectedGame2);
            selectedGameRepository.save(selectedGame3);

        }


    }
}
