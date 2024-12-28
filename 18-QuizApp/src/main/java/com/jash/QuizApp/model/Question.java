package com.jash.QuizApp.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@Entity(name = "QuizQuestions")
public class Question {

    @GeneratedValue
    @Id
    private int id;

    private String category;
    private String difficultyLevel;
    private String question;
    private String option1;
    private String option2;
    private String option3;
    private String option4;
    private String ans;
}
