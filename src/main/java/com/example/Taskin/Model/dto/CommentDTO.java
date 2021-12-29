package com.example.Taskin.Model.dto;

import com.example.Taskin.Model.Answer;
import com.example.Taskin.Model.Question;
import com.example.Taskin.Model.User;

import java.util.Date;

public class CommentDTO {
    protected String text;
    protected User author;
    protected Date date;
    protected Question question;
    protected Answer answer;

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public User getAuthor() {
        return author;
    }

    public void setAuthor(User author) {
        this.author = author;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Question getQuestion() {
        return question;
    }

    public void setQuestion(Question question) {
        this.question = question;
    }

    public Answer getAnswer() {
        return answer;
    }

    public void setAnswer(Answer answer) {
        this.answer = answer;
    }
}

