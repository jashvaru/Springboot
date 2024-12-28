package com.jash.QuizApp.repo;

import com.jash.QuizApp.model.QuizQuestion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface QuizQuesRepo extends JpaRepository<QuizQuestion, Integer> {

}
