package com.example.Taskin.Model;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
public class Question {


    @Id
    @SequenceGenerator(
            name = "question_sequence",
            sequenceName = "question_sequence",
            allocationSize = 1
    )
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator = "question_sequence")
    @Column(name = "question_id")
    private Integer questionID;

    @Column(name = "question_answer_count")
    private Integer questionAnswerCount;

    @Column(name = "question_view_count")
    private Integer questionViewCount;

    @Column(name = "question_vote_count")
    private Integer questionVoteCount;

    @Column(name = "question_title")
    private String questionTitle;

    @Column(name = "question_description")
    private String questionDescription;

    @Column(name = "question_asked_from")
    private String questionAskedFrom;

    @Column(name = "question_asked_date")
    private Date questionAskedDate;

    @OneToMany(cascade = CascadeType.ALL)
    private List<Comment> questionComments;

    @OneToMany(mappedBy = "question", cascade = CascadeType.ALL)
    private List<Answer> questionAnswer;

    @ManyToMany(mappedBy = "questions", cascade = CascadeType.ALL)
    private List<QuestionTag> questionTags;

    public Question(String questionTitle, String questionDescription, String questionAskedFrom, Date questionAskedDate, List<QuestionTag> questionTags) {
        this.questionTitle = questionTitle;
        this.questionDescription = questionDescription;
        this.questionAskedFrom = questionAskedFrom;
        this.questionAskedDate = questionAskedDate;
        this.questionTags = questionTags;
    }

    public Question() {}

    public Integer getQuestionID() {
        return questionID;
    }

}
