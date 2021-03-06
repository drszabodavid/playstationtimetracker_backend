package com.playstationbackend.playstationbackend.config;

import com.playstationbackend.playstationbackend.entity.User;
import com.playstationbackend.playstationbackend.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class DataInitializer implements CommandLineRunner {

    @Autowired
    UserRepository userRepository;

    @Autowired
    PasswordEncoder encoder;

    @Override
    public void run(String... args) throws Exception{


        userRepository.save(User.builder()
                .name("user")
                .email("user@gmail.com")
                .password(encoder.encode("12345"))
                .role("ROLE_USER")
                .build());

        userRepository.save(User.builder()
                .name("admin")
                .email("admin@gmail.com")
                .password(encoder.encode("12345"))
                .role("ROLE_USER")
                .role("ROLE_ADMIN")
                .build());
    }
}