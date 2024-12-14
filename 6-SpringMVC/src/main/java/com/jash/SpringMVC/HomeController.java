package com.jash.SpringMVC;

import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

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

    @RequestMapping("/sub")
    public String sub(@RequestParam("num1") int num, @RequestParam("num2") int num2, Model model) {
        System.out.println("sub method called");
        int result = num - num2;
        System.out.println(result);
        model.addAttribute("result", result);
        return "result.jsp";
    }

    @RequestMapping("/mul")
    public ModelAndView mul(@RequestParam("num1") int num, @RequestParam("num2") int num2, ModelAndView mv) {
        System.out.println("mul method called");
        int result = num * num2;
        System.out.println(result);
        mv.addObject("result", result);
        mv.setViewName("result.jsp");
        return mv;
    }
}
