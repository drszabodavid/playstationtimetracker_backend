package com.playstationbackend.playstationbackend.controller;



import com.playstationbackend.playstationbackend.config.JwtTokenServices;
import com.playstationbackend.playstationbackend.entity.User;
import com.playstationbackend.playstationbackend.repository.UserRepository;
import com.playstationbackend.playstationbackend.service.UserDatabaseService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

@Slf4j
@RestController
@CrossOrigin
@RequestMapping("/validation")
public class ValidationController {

    private final AuthenticationManager authenticationManager;

    private final JwtTokenServices jwtTokenServices;

    @Autowired
    UserDatabaseService userDatabaseService;

    @Autowired
    UserRepository userRepository;

    public ValidationController(AuthenticationManager authenticationManager, JwtTokenServices jwtTokenServices, UserDatabaseService users) {
        this.authenticationManager = authenticationManager;
        this.jwtTokenServices = jwtTokenServices;
    }

    @ResponseBody
    @PostMapping("/login")
    public ResponseEntity login(@RequestBody Map<String, String> userToLogin) {

        Optional<User> user = userRepository.findByName(userToLogin.get("name"));

        try {
            String name = userToLogin.get("name");
            String password = userToLogin.get("password");
            Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(name,password));
            List<String> roles = authentication.getAuthorities()
                    .stream()
                    .map(GrantedAuthority::getAuthority)
                    .collect(Collectors.toList());

            String token = jwtTokenServices.createToken(name, roles);

            Map<Object, Object> model = new HashMap<>();
            model.put("name", name);
            model.put("userId", user.get().getId());
            model.put("roles", roles);
            model.put("token", token);

            System.out.println(model.toString());
            return ResponseEntity.ok(model);

        } catch (AuthenticationException e) {
            throw new BadCredentialsException("Invalid username/password supplied");
        }
    }

    @ResponseBody
    @PostMapping("/registration")
    public void registration(@RequestBody Map<String, String> userToRegister) {
        userDatabaseService.registerUser(userToRegister);
    }
}