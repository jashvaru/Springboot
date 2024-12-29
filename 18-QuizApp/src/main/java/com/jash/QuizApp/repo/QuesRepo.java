package com.jash.QuizApp.repo;

import com.jash.QuizApp.model.Question;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface QuesRepo extends JpaRepository<Question, Integer> {

    List<Question> findByCategory(String category);

    @Query(nativeQuery = true, value = "select * from questions where category = :category order by random() limit :numQ")
    List<Question> getCategoryRandomQues(String category, int numQ);
}
