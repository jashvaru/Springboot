package com.jash.SpringMVC;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {

    @RequestMapping("/hello")
    public String home() {
        System.out.println("home page called");
        return "index.jsp";
    }

    @RequestMapping("/add")
    public String add(HttpServletRequest request) {
        System.out.println("add method called");
        int num1 = Integer.parseInt(request.getParameter("num1"));
        int num2 = Integer.parseInt(request.getParameter("num2"));
        int result = num1 + num2;
        System.out.println(result);
        return "result.jsp";
    }
}
