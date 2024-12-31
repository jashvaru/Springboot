package com.jash.QuizService.service;

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

    public String createQuiz(String category, int numQ, String title) {
//        List<Question> categoryRandomQues = quesRepo.getCategoryRandomQues(category, numQ);

        Quiz quiz = new Quiz();
        quiz.setTitle(title);
//        quiz.setQuestions(categoryRandomQues);
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

    public Integer calcPoints(int id, List<UserResponse> userResponses) {
        Optional<Quiz> quiz = quizRepo.findById(id);
        List<Question> quesFromDb = quiz.get().getQuestions();
        Map<Integer, String> quesAndAnsMap = quesFromDb.stream()
                .collect(Collectors.toMap(Question::getId, Question::getAns));

        Integer points = 0;
        for (UserResponse userResponse : userResponses) {
            if (userResponse.getUserAns().equals(quesAndAnsMap.get(userResponse.getId()))) {
                points++;
            }
        }
        return points;
    }
}
