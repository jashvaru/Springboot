package com.jash.SpringSecurity.controller;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {

    @GetMapping("/hello")
    public String hello(HttpServletRequest request) {
        return "Hello world " + request.getSession().getId();
    }
    /*
    Session ID after logging in
    Hello world 7321849B461593163E9AA66A013C311C
    * */
}
