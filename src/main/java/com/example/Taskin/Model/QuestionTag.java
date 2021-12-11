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
    @Column(name = "question_tag_id")
    private Integer questionTagID;

    @Column(name = "question_tag_name")
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

}
