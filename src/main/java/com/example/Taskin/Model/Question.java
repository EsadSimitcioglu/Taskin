package com.example.Taskin.Model;

import javax.persistence.*;
import java.sql.Date;
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
    @Column(name = "question_id", nullable = false)
    private Integer questionID;

    @Column(name = "question_title", nullable = false)
    private String questionTitle;

    @Column(name = "question_description", nullable = false)
    private String questionDescription;

    @Column(name = "question_asked_date", nullable = false)
    private Date questionAskedDate;

    @Column(name = "question_answer_count", nullable = false)
    private Integer questionAnswerCount;

    @Column(name = "question_view_count", nullable = false)
    private Integer questionViewCount;

    @Column(name = "question_vote_count", nullable = false)
    private Integer questionVoteCount;

    @ManyToOne(cascade = CascadeType.ALL)
    private Users user;

    @OneToMany(cascade = CascadeType.ALL)
    private List<Comment> questionComments;

    @OneToMany(mappedBy = "question", cascade = CascadeType.ALL)
    private List<Answer> questionAnswer;

    @ManyToMany(mappedBy = "questions", cascade = CascadeType.ALL)
    private List<QuestionTag> questionTags;

    public Question(String questionTitle, String questionDescription, Users user, Date questionAskedDate, List<QuestionTag> questionTags) {
        this.questionTitle = questionTitle;
        this.questionDescription = questionDescription;
        this.questionAskedDate = questionAskedDate;
        this.questionTags = questionTags;
        this.user = user;

        this.questionAnswerCount = 0;
        this.questionViewCount = 0;
        this.questionVoteCount = 0;

    }

    public Question() {}

    public Integer getQuestionID() {
        return questionID;
    }

    public String getQuestionTitle() {
        return questionTitle;
    }

    public String getQuestionDescription() {
        return questionDescription;
    }


    public List<QuestionTag> getQuestionTags() {
        return questionTags;
    }

    public Integer getQuestionAnswerCount() {
        return questionAnswerCount;
    }

    public Integer getQuestionViewCount() {
        return questionViewCount;
    }

    public Integer getQuestionVoteCount() {
        return questionVoteCount;
    }

    public Date getQuestionAskedDate() {
        return questionAskedDate;
    }

    public List<Comment> getQuestionComments() {
        return questionComments;
    }

    public List<Answer> getQuestionAnswer() {
        return questionAnswer;
    }

    public Users getUser() {
        return user;
    }

    @Override
    public String toString() {
        return "Question{" +
                "questionID=" + questionID +
                ", questionAnswerCount=" + questionAnswerCount +
                ", questionViewCount=" + questionViewCount +
                ", questionVoteCount=" + questionVoteCount +
                ", questionTitle='" + questionTitle + '\'' +
                ", questionDescription='" + questionDescription + '\'' +
                ", questionAskedDate=" + questionAskedDate +
                ", questionComments=" + questionComments +
                ", questionAnswer=" + questionAnswer +
                ", questionTags=" + questionTags +
                '}';
    }
}
