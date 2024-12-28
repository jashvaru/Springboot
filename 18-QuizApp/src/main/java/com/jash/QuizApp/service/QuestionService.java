package com.jash.QuizApp.service;

import com.jash.QuizApp.model.Question;
import com.jash.QuizApp.repo.QuesRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuestionService {

    @Autowired
    private QuesRepo quesRepo;

    public List<Question> getAllQues() {
        return quesRepo.findAll();
    }
}
