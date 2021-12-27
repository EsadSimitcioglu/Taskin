package com.example.Taskin.Model.dto;

import com.example.Taskin.Model.Answer;
import com.example.Taskin.Model.Question;

import java.util.Date;

public class CommentDTO {
    protected int id;
    protected String text;
    protected String author;
    protected Date date;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}

