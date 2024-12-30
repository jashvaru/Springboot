package com.jash.question_service.controller;

import com.jash.question_service.model.QuesWrapper;
import com.jash.question_service.model.Question;
import com.jash.question_service.model.UserResponse;
import com.jash.question_service.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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

    //generateQuestions
    @PostMapping("/generate")
    public ResponseEntity<List<Integer>> generateQues(@RequestParam String category, @RequestParam int numQ) {
        return new ResponseEntity<>(questionService.generateQues(category, numQ), HttpStatus.OK);
    }

    //getQuiz
    @GetMapping("/get")
    public ResponseEntity<List<QuesWrapper>> getQuesForQuiz(@RequestBody List<Integer> reqQuesIds) {
        return new ResponseEntity<>(questionService.getQuesForQuiz(reqQuesIds), HttpStatus.OK);
    }

    //CalcAns
    @PostMapping("/calcPoints")
    public ResponseEntity<Integer> calcPointsForQuiz(@RequestBody List<UserResponse> userResponse) {
        return new ResponseEntity<>(questionService.calcPointsForQuiz(userResponse), HttpStatus.OK);
    }


}
