package com.jash.SpringSecurity.controller;

import com.jash.SpringSecurity.model.User;
import com.jash.SpringSecurity.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    UserService userService;

    @PostMapping("register")
    public User registerUser(@RequestBody User user) {
        System.out.println("Insider User Controller");
        return userService.saveUser(user);
    }

    @GetMapping("user")
    public List<User> getUser() {
        return userService.getAllUser();
    }
}
