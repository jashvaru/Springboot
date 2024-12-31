package com.jash.QuizService.model;

import jakarta.persistence.*;

import java.util.List;



@Entity(name = "Quiz")
public class Quiz {

    @Id
    @GeneratedValue
    private int id;

    private String title;

    @ElementCollection
    private List<Integer> questions;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<Integer> getQuestions() {
        return questions;
    }

    public void setQuestions(List<Integer> questions) {
        this.questions = questions;
    }

    public Quiz() {
    }
}
