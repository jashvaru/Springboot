package com.jash.QuizApp.controller;

import com.jash.QuizApp.model.Question;
import com.jash.QuizApp.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/questions")
public class QuestionController {

    @Autowired
    private QuestionService questionService;

    @RequestMapping("/allques")
    public List<Question> getAllQues() {
        return questionService.getAllQues();
    }
}
