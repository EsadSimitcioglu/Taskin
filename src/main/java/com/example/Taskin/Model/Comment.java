package com.example.Taskin.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.sql.Date;

@Entity
public class Comment {

    @Id
    @SequenceGenerator(
            name = "comment_sequence",
            sequenceName = "comment_sequence",
            allocationSize = 1
    )
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator = "comment_sequence")
    @Column(name = "comment_id")
    private Integer commentID;

    @Column(name = "comment_text")
    private String commentText;

    @Column(name = "comment_writer")
    private String commentWriter;

    @Column(name = "comment_date")
    private Date commentDate;

    @JsonIgnore
    @ManyToOne(cascade = CascadeType.ALL)
    private Question question;

    @JsonIgnore
    @ManyToOne(cascade = CascadeType.ALL)
    private Answer answer;

    public Comment(String commentText, String commentWriter, Date commentDate, Question question) {
        this.commentText = commentText;
        this.commentWriter = commentWriter;
        this.commentDate = commentDate;
        this.question = question;
    }

    public Comment(String commentText, String commentWriter, Date commentDate, Answer answer) {
        this.commentText = commentText;
        this.commentWriter = commentWriter;
        this.commentDate = commentDate;
        this.answer = answer;
    }

    public Comment() {}

    public Integer getCommentID() {
        return commentID;
    }

    public void setCommentID(Integer commentID) {
        this.commentID = commentID;
    }

    public String getCommentText() {
        return commentText;
    }

    public void setCommentText(String commentText) {
        this.commentText = commentText;
    }

    public String getCommentWriter() {
        return commentWriter;
    }

    public void setCommentWriter(String commentWriter) {
        this.commentWriter = commentWriter;
    }

    public Date getCommentDate() {
        return commentDate;
    }

    public void setCommentDate(Date commentDate) {
        this.commentDate = commentDate;
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
