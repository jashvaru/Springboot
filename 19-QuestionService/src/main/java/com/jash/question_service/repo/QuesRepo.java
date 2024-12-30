package com.jash.question_service.repo;

import com.jash.question_service.model.Question;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface QuesRepo extends JpaRepository<Question, Integer> {

    List<Question> findByCategory(String category);

    @Query(nativeQuery = true, value = "select id from questions where category = :category order by random() limit :numQ")
    List<Integer> getCategoryRandomQues(String category, int numQ);

    List<Question> findAllByIdIn(List<Integer> ids);
}
