package com.playstationbackend.playstationbackend.service;

import com.playstationbackend.playstationbackend.entity.User;
import com.playstationbackend.playstationbackend.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.Optional;

@Service
@Slf4j
public class UserDatabaseService {

    @Autowired
    UserRepository userRepository;

    @Autowired
    PasswordEncoder encoder;

    public void registerUser(Map<String, String> userData){
        log.info(userData.toString());
        User user = new User().builder()
                .email(userData.get("email"))
                .password(encoder.encode(userData.get("password")))
                .name(userData.get("name"))
                .role("ROLE_USER")
                .build();


        userRepository.save(user);
        log.info("-----------------");
        log.info("-----------------");
        log.info(user.toString());
        log.info("-----------------");
        log.info("-----------------");
    }


}
