package com.jash.QuizApp.service;

import com.jash.QuizApp.model.QuesWrapper;
import com.jash.QuizApp.model.Question;
import com.jash.QuizApp.model.Quiz;
import com.jash.QuizApp.repo.QuesRepo;
import com.jash.QuizApp.repo.QuizRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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

    public List<QuesWrapper> getQuiz(int id) {
        Optional<Quiz> quiz = quizRepo.findById(id);
        List<Question> quesFromDb = quiz.get().getQuestions();
        List<QuesWrapper> quesForUser = new ArrayList<>();
        for(Question q: quesFromDb) {
            QuesWrapper quesWrapper = new QuesWrapper(q.getId(), q.getQuestion(),
                    q.getOption1(), q.getOption2(), q.getOption3(), q.getOption4());
            quesForUser.add(quesWrapper);
        }
        return quesForUser;
    }
}
