package com.jash.QuizApp.service;

import com.jash.QuizApp.model.Question;
import com.jash.QuizApp.model.Quiz;
import com.jash.QuizApp.repo.QuesRepo;
import com.jash.QuizApp.repo.QuizRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuizService {

    @Autowired
    QuizRepo quizRepo;

    @Autowired
    QuesRepo quesRepo;

    public String createQuiz(String category, int numQ, String title) {
        List<Question> categoryRandomQues = quesRepo.getCategoryRandomQues(category, numQ);

        Quiz quiz = new Quiz();
        quiz.setTitle(title);
        quiz.setQuestions(categoryRandomQues);
        quizRepo.save(quiz);
        return "Success";
    }
}
