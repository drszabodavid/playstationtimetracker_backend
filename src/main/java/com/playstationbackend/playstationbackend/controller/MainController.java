package com.playstationbackend.playstationbackend.controller;

import com.playstationbackend.playstationbackend.entity.Game;
import com.playstationbackend.playstationbackend.entity.User;
import com.playstationbackend.playstationbackend.repository.GameRepository;
import com.playstationbackend.playstationbackend.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class MainController {


    @Autowired
    private PersonRepository personRepository;

    @Autowired
    private GameRepository gameRepository;

    @ResponseBody
    @RequestMapping(value = "/games", produces = "application/json")
    public List<Game> getAllGames() {
        List<Game> allGames = gameRepository.findAll();

        return allGames;
    }

    @ResponseBody
    @RequestMapping(value = "/users", produces = "application/json")
    public List<User> getAllUsers() {
        List<User> allUser = personRepository.findAll();

        return allUser;
    }
}
