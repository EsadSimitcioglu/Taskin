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
    @Column(name = "comment_id", nullable = false)
    private Integer commentID;

    @Column(name = "comment_text", nullable = false)
    private String commentText;

    @Column(name = "comment_date", nullable = false)
    private Date commentDate;

    @Column(name = "comment_vote_count")
    private Integer commentVoteCount;

    @ManyToOne(cascade = CascadeType.ALL)
    private Users user;

    @JsonIgnore
    @ManyToOne(cascade = CascadeType.ALL)
    private Question question;

    @JsonIgnore
    @ManyToOne(cascade = CascadeType.ALL)
    private Answer answer;


    public Comment(String commentText, Users user, Date commentDate, Question question) {
        this.commentText = commentText;
        this.commentDate = commentDate;
        this.question = question;
        this.user = user;
    }

    public Comment(String commentText, Users user, Date commentDate, Answer answer) {
        this.commentText = commentText;
        this.commentDate = commentDate;
        this.answer = answer;
        this.user = user;
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

    public Integer getCommentVoteCount() {
        return commentVoteCount;
    }

    public void setCommentVoteCount(Integer commentVoteCount) {
        this.commentVoteCount = commentVoteCount;
    }

    public Users getUser() {
        return user;
    }

    public void setUser(Users user) {
        this.user = user;
    }
}
