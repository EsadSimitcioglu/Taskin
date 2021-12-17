package com.example.Taskin.Model;

import javax.persistence.*;
import java.util.Date;
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
    @Column(name = "answer_id")
    private Integer answerID;

    @Column(name = "answer_text")
    private String answerText;

    @Column(name = "answer_vote_count")
    private Integer answerVoteCount;

    @Column(name = "answer_from")
    private String answerFrom;

    @Column(name = "answer_date")
    private Date answerDate;

    @ManyToOne(cascade = CascadeType.ALL)
    private Question question;

    @OneToMany(mappedBy = "answer", cascade = CascadeType.ALL)
    private List<Comment> answerComments;

    public Answer(String answerText, String answerFrom, Date answerDate,Question question) {
        this.answerText = answerText;
        this.answerFrom = answerFrom;
        this.answerDate = answerDate;
        this.question = question;
    }

    public Answer() {}

    public Integer getAnswerID() {
        return answerID;
    }
}
