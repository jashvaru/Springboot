package com.jash.question_service.service;

import com.jash.question_service.model.Question;
import com.jash.question_service.repo.QuesRepo;
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

    public List<Question> getQuesByCategory(String category) {
        return quesRepo.findByCategory(category);

    }

    public void addQues(Question question) {
        quesRepo.save(question);
    }
}
