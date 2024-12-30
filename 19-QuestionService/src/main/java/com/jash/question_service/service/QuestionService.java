package com.jash.question_service.service;

import com.jash.question_service.model.QuesWrapper;
import com.jash.question_service.model.Question;
import com.jash.question_service.repo.QuesRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
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

    public List<Integer> generateQues(String category, int numQ) {
        return quesRepo.getCategoryRandomQues(category, numQ);
    }

    public List<QuesWrapper> getQuesForQuiz(List<Integer> reqQuesIds) {
        List<Question> questions = quesRepo.findAllByIdIn(reqQuesIds);
        List<QuesWrapper> quesForUser = new ArrayList<>();
        for(Question q: questions) {
            QuesWrapper quesWrapper = new QuesWrapper(q.getId(), q.getQuestion(),
                    q.getOption1(), q.getOption2(), q.getOption3(), q.getOption4());
            quesForUser.add(quesWrapper);
        }
        return quesForUser;
    }
}
