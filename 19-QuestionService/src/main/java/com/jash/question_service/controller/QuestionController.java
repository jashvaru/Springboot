package com.jash.question_service.controller;

import com.jash.question_service.model.Question;
import com.jash.question_service.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping("/add")
    public List<Question> addQues(@RequestBody Question question) {
        questionService.addQues(question);
        return questionService.getAllQues();
    }


}
