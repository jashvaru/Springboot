package com.jash.QuizApp.controller;

import com.jash.QuizApp.model.Question;
import com.jash.QuizApp.service.QuestionService;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/questions")
public class QuestionController {

    @Autowired
    private QuestionService questionService;

    @GetMapping("/allques")
    public List<Question> getAllQues() {
        return questionService.getAllQues();
    }

    @GetMapping("/category/{category}")
    public List<Question> getQuesByCategory(@PathVariable String category) {
        return questionService.getQuesByCategory(category);
    }


}
