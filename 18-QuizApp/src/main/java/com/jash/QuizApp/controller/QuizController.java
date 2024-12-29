package com.jash.QuizApp.controller;

import com.jash.QuizApp.model.QuesWrapper;
import com.jash.QuizApp.service.QuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/quiz")
public class QuizController {

    @Autowired
    QuizService quizService;

    @RequestMapping("/create")
    public ResponseEntity<String> createQuiz(@RequestParam String category, @RequestParam int numQ, @RequestParam String title) {
        return new ResponseEntity<>(quizService.createQuiz(category, numQ, title), HttpStatus.OK);
    }

    @RequestMapping("/get")
    public ResponseEntity<List<QuesWrapper>> getQuiz(@RequestParam int id) {
        return new ResponseEntity<>(quizService.getQuiz(id), HttpStatus.OK);
    }
}
