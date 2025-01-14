package com.jash.QuizService.service;

import com.jash.QuizService.feign.QuizFeignClient;
import com.jash.QuizService.model.QuesWrapper;
import com.jash.QuizService.model.Question;
import com.jash.QuizService.model.Quiz;
import com.jash.QuizService.model.UserResponse;
import com.jash.QuizService.repo.QuizRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class QuizService {

    @Autowired
    QuizRepo quizRepo;

    @Autowired
    QuizFeignClient quizFeignClient;

    public String createQuiz(String category, int numQ, String title) {
        List<Integer> categoryRandomQuesId = quizFeignClient.generateQues(category, numQ).getBody();

        Quiz quiz = new Quiz();
        quiz.setTitle(title);
        quiz.setQuestions(categoryRandomQuesId);
        quizRepo.save(quiz);
        return "Success";
    }

    public List<QuesWrapper> getQuiz(int id) {
        Optional<Quiz> quiz = quizRepo.findById(id);
        List<Integer> quesIdFromDb = quiz.get().getQuestions();
        List<QuesWrapper> quesForUser = new ArrayList<>();
        quesForUser = quizFeignClient.getQuesForQuiz(quesIdFromDb).getBody();
        return quesForUser;
    }

    public Integer calcPoints(int id, List<UserResponse> userResponses) {
        return quizFeignClient.calcPointsForQuiz(userResponses).getBody();
    }
}
