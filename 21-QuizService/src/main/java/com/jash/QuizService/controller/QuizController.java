package com.jash.QuizService.controller;

import com.jash.QuizService.model.CreateQuizDto;
import com.jash.QuizService.model.QuesWrapper;
import com.jash.QuizService.model.UserResponse;
import com.jash.QuizService.service.QuizService;
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
    public ResponseEntity<String> createQuiz(@RequestBody CreateQuizDto createQuizDto) {
        return new ResponseEntity<>(quizService.createQuiz(createQuizDto.getCategory(),
                createQuizDto.getNumQ(), createQuizDto.getTitle()), HttpStatus.OK);
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
