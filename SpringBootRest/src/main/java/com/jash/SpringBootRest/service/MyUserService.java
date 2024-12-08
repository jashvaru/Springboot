package com.jash.SpringBootRest.service;

import com.jash.SpringBootRest.model.User;
import com.jash.SpringBootRest.model.UserPrincipal;
import com.jash.SpringBootRest.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class MyUserService implements UserDetailsService {

    @Autowired
    UserRepo userRepo;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepo.findByUsername(username).orElse(null);

         if(Objects.isNull(user)) {
             throw new UsernameNotFoundException("User: %s".formatted(username));
         }
        return new UserPrincipal(user);
    }
}
