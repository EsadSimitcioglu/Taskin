package com.example.Taskin.Model;

import javax.persistence.*;
import java.util.List;

@Entity
public class QuestionTag {

    @Id
    @SequenceGenerator(
            name = "question_tag_sequence",
            sequenceName = "question_tag_sequence",
            allocationSize = 1
    )
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator = "question_tag_sequence")
    @Column(name = "question_tag_id", nullable = false)
    private Integer questionTagID;

    @Column(name = "question_tag_name", nullable = false)
    private String questionTagName;

    @ManyToMany(mappedBy = "questionTags", cascade = CascadeType.ALL)
    private List<Question> questions;

    public QuestionTag() {}

    public String getQuestionTagName() {
        return questionTagName;
    }

    public void setQuestionTagName(String questionTagName) {
        this.questionTagName = questionTagName;
    }

}
