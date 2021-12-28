package com.example.Taskin.Model.dto;

import com.example.Taskin.Model.Question;
import com.example.Taskin.Model.User;

import java.util.Date;

public class AnswerDTO {
    protected int id;
    protected String answerText;
    protected int voteCount;
    protected String answerFrom;
    protected Date answerDate;
    protected User user;
    protected Question question;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAnswerText() {
        return answerText;
    }

    public void setAnswerText(String answerText) {
        this.answerText = answerText;
    }

    public int getVoteCount() {
        return voteCount;
    }

    public void setVoteCount(int voteCount) {
        this.voteCount = voteCount;
    }

    public String getAnswerFrom() {
        return answerFrom;
    }

    public void setAnswerFrom(String answerFrom) {
        this.answerFrom = answerFrom;
    }

    public Date getAnswerDate() {
        return answerDate;
    }

    public void setAnswerDate(Date answerDate) {
        this.answerDate = answerDate;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Question getQuestion() {
        return question;
    }

    public void setQuestion(Question question) {
        this.question = question;
    }
}
