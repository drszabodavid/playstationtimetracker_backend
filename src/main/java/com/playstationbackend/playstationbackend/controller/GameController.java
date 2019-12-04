package com.playstationbackend.playstationbackend.controller;

import com.playstationbackend.playstationbackend.model.ComplexGame;
import com.playstationbackend.playstationbackend.repository.SelectedGameRepository;
import com.playstationbackend.playstationbackend.service.GameDatabaseService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;


@Controller
@Slf4j
@CrossOrigin
@RequestMapping
public class GameController {

    @Autowired
    SelectedGameRepository selectedGameRepository;

    @Autowired
    GameDatabaseService gameDatabaseService;

    @ResponseBody
    @GetMapping(value = "/{userId}/games", produces = "application/json")
    public List<ComplexGame> getEventByCity(@PathVariable("userId") Long userId) {
        return gameDatabaseService.getAllGamesForaUser(userId);
    }

    @ResponseBody
    @PostMapping(value = "/games/update")
    public void updatePlayTimeByGame(@RequestBody Map<String, String> gameToUpdate) {
        gameDatabaseService.updateTimeForGame(gameToUpdate);
    }

    @ResponseBody
    @PostMapping(value = "/games/complete/{selectedGameId}")
    public void updateCompletionByGame(@PathVariable Long selectedGameId) {
        gameDatabaseService.updateCompletedForGame(selectedGameId);
    }

    @ResponseBody
    @PostMapping(value = "/games/star/{selectedGameId}")
    public void updateStarredByGame(@PathVariable Long selectedGameId) {
        gameDatabaseService.updateStarredForGame(selectedGameId);
    }

    @ResponseBody
    @PostMapping(value = "/games/{selectedGameId}")
    public void deletePost(@PathVariable Long selectedGameId) {
        selectedGameRepository.deleteById(selectedGameId);
    }

    @ResponseBody
    @PostMapping(value = "/games/save")
    public void saveEventToDatabase(@RequestBody Map<String, String> game) {
        gameDatabaseService.saveNewGameToDatabase(game);
    }




}
