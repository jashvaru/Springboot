package com.jash.SpringSecurity.controller;

import com.jash.SpringSecurity.model.User;
import com.jash.SpringSecurity.service.JWTService;
import com.jash.SpringSecurity.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JWTService jwtService;

    @PostMapping("register")
    public User registerUser(@RequestBody User user) {
        System.out.println("Inside User Controller");
        return userService.saveUser(user);
    }

    @PostMapping("login")
    public String loginUser(@RequestBody User user) {
        System.out.println("Inside User login Controller");
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(user.getUsername(), user.getPassword()));

        if(authentication.isAuthenticated()) {
            return jwtService.generateToken(user.getUsername());
        } else {
            return "Failed";
        }
    }

    @GetMapping("user")
    public List<User> getUser() {
        return userService.getAllUser();
    }
}
