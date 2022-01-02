package com.example.Taskin.Model.dto;

import com.example.Taskin.Model.QuestionTag;
import com.example.Taskin.Model.Users;

import java.sql.Date;
import java.util.List;

public class QuestionDTO {
    protected int id;
    protected String title;
    protected String description;
    protected Users author;
    protected Date date;
    protected int answerCount = 0;
    protected int viewCount = 1;
    protected int voteCount = 0;
    protected List<QuestionTag> questionTags;

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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Users getAuthor() {
        return author;
    }

    public void setAuthor(Users author) {
        this.author = author;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public int getAnswerCount() {
        return answerCount;
    }

    public void setAnswerCount(int answerCount) {
        this.answerCount = answerCount;
    }

    public int getViewCount() {
        return viewCount;
    }

    public void setViewCount(int viewCount) {
        this.viewCount = viewCount;
    }

    public int getVoteCount() {
        return voteCount;
    }

    public void setVoteCount(int voteCount) {
        this.voteCount = voteCount;
    }

    public List<QuestionTag> getQuestionTags() {
        return questionTags;
    }

    public void setQuestionTags(List<QuestionTag> questionTags) {
        this.questionTags = questionTags;
    }

    @Override
    public String toString() {
        return "QuestionDTO{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", author=" + author +
                ", date=" + date +
                ", answerCount=" + answerCount +
                ", viewCount=" + viewCount +
                ", voteCount=" + voteCount +
                ", questionTags=" + questionTags +
                '}';
    }
}
