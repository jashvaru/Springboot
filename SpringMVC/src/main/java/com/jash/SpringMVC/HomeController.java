package com.jash.SpringMVC;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HomeController {

    @RequestMapping("/hello")
    public String home() {
        System.out.println("home page called");
        return "index.jsp";
    }

    @RequestMapping("/add")
    public String add(@RequestParam("num1") int num, @RequestParam("num2") int num2, HttpSession session) {
        System.out.println("add method called");
        int result = num + num2;
        System.out.println(result);
        session.setAttribute("result", result);
        return "result.jsp";
    }
}
