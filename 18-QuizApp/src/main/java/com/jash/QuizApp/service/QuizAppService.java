package com.jash.QuizApp.service;

import com.jash.QuizApp.model.QuizQuestion;
import com.jash.QuizApp.repo.QuizQuesRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuizAppService {

    @Autowired
    private QuizQuesRepo quizQuesRepo;

    public List<QuizQuestion> getAllQues() {
        return quizQuesRepo.findAll();
    }
}
