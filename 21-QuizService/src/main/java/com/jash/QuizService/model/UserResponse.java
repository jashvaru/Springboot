package com.jash.QuizService.model;

public class UserResponse {
    private int id;
    private String userAns;

    public UserResponse() {
    }

    public UserResponse(int id, String userAns) {
        this.id = id;
        this.userAns = userAns;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUserAns() {
        return userAns;
    }

    public void setUserAns(String userAns) {
        this.userAns = userAns;
    }
}
