package com.playstationbackend.playstationbackend.controller;

import com.playstationbackend.playstationbackend.entity.User;
import com.playstationbackend.playstationbackend.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Optional;

@Controller
@Slf4j
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @ResponseBody
    @RequestMapping(value = "/{userId}", produces = "application/json")
    public Optional<User> getUserDetailsById(@PathVariable("userId") Long userId) {
        return userRepository.findById(userId);
    }

    @ResponseBody
    @RequestMapping(value = "/users", produces = "application/json")
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }
}
