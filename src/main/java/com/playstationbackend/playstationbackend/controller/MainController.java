package com.playstationbackend.playstationbackend.controller;

import com.playstationbackend.playstationbackend.entity.Game;
import com.playstationbackend.playstationbackend.entity.User;
import com.playstationbackend.playstationbackend.repository.GameRepository;
import com.playstationbackend.playstationbackend.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MainController {


    @Autowired
    private PersonRepository personRepository;

    @Autowired
    private GameRepository gameRepository;

    @ResponseBody
    @RequestMapping("/")
    public String index() {
        Iterable<User> all = personRepository.findAll();

        StringBuilder sb = new StringBuilder();

        all.forEach(p -> sb.append(p.getName() + "<br>"));

        return sb.toString();
    }

    @ResponseBody
    @RequestMapping("/games")
    public String games() {
        Iterable<Game> games = gameRepository.findAll();

        StringBuilder sb = new StringBuilder();

        games.forEach(g -> sb.append(g.toString() + "<br>"));

        return sb.toString();
    }
}
