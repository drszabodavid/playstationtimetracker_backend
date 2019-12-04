package com.playstationbackend.playstationbackend.controller;

import com.playstationbackend.playstationbackend.entity.Game;
import com.playstationbackend.playstationbackend.entity.SelectedGame;
import com.playstationbackend.playstationbackend.entity.User;
import com.playstationbackend.playstationbackend.model.ComplexGame;
import com.playstationbackend.playstationbackend.repository.GameRepository;
import com.playstationbackend.playstationbackend.repository.SelectedGameRepository;
import com.playstationbackend.playstationbackend.repository.UserRepository;
import com.playstationbackend.playstationbackend.service.DatabaseService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
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
    DatabaseService databaseService;

    @ResponseBody
    @GetMapping(value = "/{userId}/games", produces = "application/json")
    public List<ComplexGame> getEventByCity(@PathVariable("userId") Long userId) {
        return databaseService.getAllGamesForaUser(userId);
    }

    @ResponseBody
    @PostMapping(value = "/games/update")
    public void updatePlayTimeByGame(@RequestBody Map<String, String> gameToUpdate) {
        log.info("----------------------");
        log.info("----------------------");
        log.info(gameToUpdate.toString());
        log.info("----------------------");
        log.info("----------------------");
        databaseService.updateTimeForGame(gameToUpdate);
    }

    @ResponseBody
    @PostMapping(value = "/games/complete/{selectedGameId}")
    public void updateCompletionByGame(@PathVariable Long selectedGameId) {
        databaseService.updateCompletedForGame(selectedGameId);
    }

    @ResponseBody
    @PostMapping(value = "/games/star/{selectedGameId}")
    public void updateStarredByGame(@PathVariable Long selectedGameId) {
        databaseService.updateStarredForGame(selectedGameId);
    }

    @ResponseBody
    @DeleteMapping(value = "/games/{selectedGameId}")
    public void deletePost(@PathVariable Long selectedGameId) {
        selectedGameRepository.deleteById(selectedGameId);
    }

    @ResponseBody
    @PostMapping(value = "/games/save")
    public void saveEventToDatabase(@RequestBody Map<String, String> game) {
        databaseService.saveNewGameToDatabase(game);
    }




}
