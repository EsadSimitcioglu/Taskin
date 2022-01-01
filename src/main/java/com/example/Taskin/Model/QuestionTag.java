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

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "question_tag_map",
            joinColumns = @JoinColumn(
                    name = "question_tag_id",
                    referencedColumnName = "question_tag_id"
            ),
            inverseJoinColumns = @JoinColumn(
                    name = "question_id",
                    referencedColumnName = "question_id"
            )
    )
    private List<Question> questions;

    public QuestionTag() {}
}
