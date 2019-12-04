package com.playstationbackend.playstationbackend.service;

import com.playstationbackend.playstationbackend.entity.Game;
import com.playstationbackend.playstationbackend.entity.SelectedGame;
import com.playstationbackend.playstationbackend.entity.User;
import com.playstationbackend.playstationbackend.model.ComplexGame;
import com.playstationbackend.playstationbackend.repository.GameRepository;
import com.playstationbackend.playstationbackend.repository.SelectedGameRepository;
import com.playstationbackend.playstationbackend.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;


@Service
@Slf4j
public class GameDatabaseService {

    @Autowired
    UserRepository userRepository;
    @Autowired
    SelectedGameRepository selectedGameRepository;
    @Autowired
    GameRepository gameRepository;

    public List<ComplexGame> getAllGamesForaUser(Long userId) {
        Optional<User> user = userRepository.findById(userId);
        List<SelectedGame> allgames = selectedGameRepository.getAllByUser(user);
        return createComplexGameList(allgames);
    }

    private List<ComplexGame> createComplexGameList(List<SelectedGame> allgames) {
        List<ComplexGame> userGames = new ArrayList<>();

        for (SelectedGame selectedGame : allgames) {
            Optional<Game> game = gameRepository.findById(selectedGame.getGameId());

            ComplexGame complexGame = new ComplexGame().builder()
                    .id(selectedGame.getId())
                    .gameId(selectedGame.getGameId())
                    .name(game.get().getName())
                    .imageUrl(game.get().getImageUrl())
                    .gameplayCompletionist(game.get().getGameplayCompletionist())
                    .gameplayMain(game.get().getGameplayMain())
                    .gameplayMainExtra(game.get().getGameplayMainExtra())
                    .liked(selectedGame.isLiked())
                    .completed(selectedGame.isCompleted())
                    .timeSpent(selectedGame.getTimeSpent())
                    .remainingTime(selectedGame.getRemainingTime()).build();
            userGames.add(complexGame);
        }

        return userGames;
    }

    public void saveNewGameToDatabase(Map<String, String> game) {
        gameBuilder(game);
        Optional<User> user = userRepository.findById(Long.parseLong(game.get("UserId")));
        selectedGameBuilder(user.get(), game);

    }

    private void gameBuilder(Map<String, String> game) {
        Game gameToSave = new Game().builder()
                .imageUrl(game.get("imageUrl"))
                .name(game.get("name"))
                .gameplayCompletionist(Double.parseDouble(game.get("gameplayCompletionist")))
                .gameplayMain(Double.parseDouble(game.get("gameplayMain")))
                .gameplayMainExtra(Double.parseDouble(game.get("gameplayMainExtra")))
                .id(game.get("id")).build();
        gameRepository.save(gameToSave);
    }

    private void selectedGameBuilder(User user, Map<String, String> game) {
        SelectedGame selectedGame = new SelectedGame().builder()
                .user(user)
                .liked(false)
                .completed(false)
                .timeSpent(0)
                .remainingTime(Double.parseDouble(game.get("gameplayMain")))
                .gameId(game.get("id"))
                .build();
        selectedGameRepository.save(selectedGame);
    }

    public void updateTimeForGame(Map<String, String> gameToUpdate) {
        Optional<SelectedGame> selectedGame = selectedGameRepository.findById(Long.parseLong(gameToUpdate.get("gameId")));
        double timeToAdd = Double.parseDouble(gameToUpdate.get("time"));
        double currentTimeSpent = selectedGame.get().getTimeSpent();

        selectedGame.get().setTimeSpent(currentTimeSpent + timeToAdd);
        selectedGameRepository.save(selectedGame.get());

        updateRemainingTime(selectedGame, timeToAdd);
    }

    public void updateCompletedForGame(Long gameToUpdate) {
        Optional<SelectedGame> selectedGame = selectedGameRepository.findById(gameToUpdate);
        if (selectedGame.get().isCompleted()) {
            selectedGame.get().setCompleted(false);
        } else {
            selectedGame.get().setCompleted(true);
            selectedGame.get().setLiked(false);
        }
        selectedGameRepository.save(selectedGame.get());
    }

    public void updateStarredForGame(Long gameToUpdate) {
        Optional<SelectedGame> selectedGame = selectedGameRepository.findById(gameToUpdate);
        if (selectedGame.get().isLiked()) {
            selectedGame.get().setLiked(false);
        } else {
            selectedGame.get().setLiked(true);
        }
        selectedGameRepository.save(selectedGame.get());
    }

    private void updateRemainingTime(Optional<SelectedGame> selectedGame, double timeToAdd) {
        double newRemainingTime = selectedGame.get().getRemainingTime() - timeToAdd;
        if (newRemainingTime <= 0) {
            selectedGame.get().setRemainingTime(0);
        } else {
            selectedGame.get().setRemainingTime(newRemainingTime);
        }
        selectedGameRepository.save(selectedGame.get());
    }


}
