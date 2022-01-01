package com.example.Taskin.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.sql.Date;
import java.util.List;

@Entity
public class Answer {

    @Id
    @SequenceGenerator(
            name = "answer_sequence",
            sequenceName = "answer_sequence",
            allocationSize = 1
    )
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator = "answer_sequence")
    @Column(name = "answer_id", nullable = false)
    private Integer answerID;

    @Column(name = "answer_text", nullable = false)
    private String answerText;

    @Column(name = "answer_vote_count")
    private Integer answerVoteCount;

    @Column(name = "answer_date", nullable = false)
    private Date answerDate;

    @ManyToOne(cascade = CascadeType.ALL)
    private Users user;

    @JsonIgnore
    @ManyToOne(cascade = CascadeType.ALL)
    private Question question;

    @OneToMany(mappedBy = "answer", cascade = CascadeType.ALL)
    private List<Comment> answerComments;

    public Answer(String answerText, Users user, Date answerDate, Question question) {
        this.answerText = answerText;
        this.answerDate = answerDate;
        this.question = question;
        this.user = user;
        this.answerVoteCount = 0;
    }

    public Answer() {}

    public Integer getAnswerID() {
        return answerID;
    }

    public void setAnswerID(Integer answerID) {
        this.answerID = answerID;
    }

    public String getAnswerText() {
        return answerText;
    }

    public void setAnswerText(String answerText) {
        this.answerText = answerText;
    }

    public Integer getAnswerVoteCount() {
        return answerVoteCount;
    }

    public void setAnswerVoteCount(Integer answerVoteCount) {
        this.answerVoteCount = answerVoteCount;
    }

    public Date getAnswerDate() {
        return answerDate;
    }

    public void setAnswerDate(Date answerDate) {
        this.answerDate = answerDate;
    }

    public Question getQuestion() {
        return question;
    }

    public void setQuestion(Question question) {
        this.question = question;
    }

    public List<Comment> getAnswerComments() {
        return answerComments;
    }

    public void setAnswerComments(List<Comment> answerComments) {
        this.answerComments = answerComments;
    }

    public Users getUser() {
        return user;
    }

    public void setUser(Users user) {
        this.user = user;
    }
}
