package com.jash.QuizApp.controller;

import com.jash.QuizApp.model.QuizQuestion;
import com.jash.QuizApp.service.QuizAppService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class QuizAppController {

    @Autowired
    private QuizAppService quizAppService;

    @RequestMapping("/questions/getall")
    public List<QuizQuestion> getAllQues() {
        return quizAppService.getAllQues();
    }
}
