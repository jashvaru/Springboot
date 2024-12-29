package com.jash.QuizApp.controller;

import com.jash.QuizApp.model.QuesWrapper;
import com.jash.QuizApp.model.UserResponse;
import com.jash.QuizApp.service.QuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/quiz")
public class QuizController {

    @Autowired
    QuizService quizService;

    @PostMapping("/create")
    public ResponseEntity<String> createQuiz(@RequestParam String category, @RequestParam int numQ, @RequestParam String title) {
        return new ResponseEntity<>(quizService.createQuiz(category, numQ, title), HttpStatus.OK);
    }

    @GetMapping("/get")
    public ResponseEntity<List<QuesWrapper>> getQuiz(@RequestParam int id) {
        return new ResponseEntity<>(quizService.getQuiz(id), HttpStatus.OK);
    }

    @PostMapping("/submit/{id}")
    public ResponseEntity<Integer> submitQuiz(@PathVariable int id, @RequestBody List<UserResponse> userResponses) {
        return new ResponseEntity<>(quizService.calcPoints(id, userResponses), HttpStatus.OK);
    }
}
