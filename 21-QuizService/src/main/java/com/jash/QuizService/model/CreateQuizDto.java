package com.jash.QuizService.model;


import org.springframework.web.bind.annotation.RequestParam;

public class CreateQuizDto {

    private String category;
    private int numQ;
    private String title;

    public CreateQuizDto() {
    }

    public CreateQuizDto(String category, Integer numQ, String title) {
        this.category = category;
        this.numQ = numQ;
        this.title = title;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public Integer getNumQ() {
        return numQ;
    }

    public void setNumQ(Integer numQ) {
        this.numQ = numQ;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
