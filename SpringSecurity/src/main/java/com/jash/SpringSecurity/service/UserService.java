package com.jash.SpringSecurity.service;

import com.jash.SpringSecurity.model.User;
import com.jash.SpringSecurity.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    UserRepo userRepo;

    public User saveUser(User user) {
        System.out.println("Insider save user");
        return userRepo.save(user);
    }

    public List<User> getAllUser() {
        return userRepo.findAll();
    }
}
