package com.example.Taskin.Model.dto;

import com.example.Taskin.Model.QuestionTag;
import com.example.Taskin.Model.Users;

import java.sql.Date;
import java.util.List;

public class QuestionDTO {
    protected String title;
    protected String description;
    protected Integer voteCount = 0;
    protected Users author;
    protected Date date;
    protected List<QuestionTag> questionTags;

    public Integer getVoteCount() {
        return voteCount;
    }

    public void setVoteCount(Integer voteCount) {
        this.voteCount = voteCount;
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

    public List<QuestionTag> getQuestionTags() {
        return questionTags;
    }

    public void setQuestionTags(List<QuestionTag> questionTags) {
        this.questionTags = questionTags;
    }
}
