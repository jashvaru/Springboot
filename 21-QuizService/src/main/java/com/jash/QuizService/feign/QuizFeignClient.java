package com.jash.QuizService.feign;

import com.jash.QuizService.model.QuesWrapper;
import com.jash.QuizService.model.UserResponse;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@FeignClient(name = "QUESTION-SERVICE")
public interface QuizFeignClient {

    @PostMapping("/questions/generate")
    public ResponseEntity<List<Integer>> generateQues(@RequestParam String category, @RequestParam int numQ);

    @PostMapping("/questions/get")
    public ResponseEntity<List<QuesWrapper>> getQuesForQuiz(@RequestBody List<Integer> reqQuesIds);

    @PostMapping("/questions/calcPoints")
    public ResponseEntity<Integer> calcPointsForQuiz(@RequestBody List<UserResponse> userResponse);
}
