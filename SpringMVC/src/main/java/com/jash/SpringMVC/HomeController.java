package com.jash.SpringMVC;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {

    @RequestMapping("/hello")
    public String home() {
        System.out.println("home page called");
        return "index.jsp";
    }
}
