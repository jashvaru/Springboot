package com.jash.QuizApp.repo;

import com.jash.QuizApp.model.Question;
import org.springframework.data.jpa.repository.JpaRepository;

public interface QuesRepo extends JpaRepository<Question, Integer> {

}
