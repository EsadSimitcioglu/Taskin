package com.example.Taskin.Model;

import javax.persistence.*;
import java.util.Date;

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

    @ManyToOne(cascade = CascadeType.ALL)
    private Question question;

    @ManyToOne(cascade = CascadeType.ALL)
    private Answer answer;

    public Comment(String commentText, String commentWriter, Date commentDate,Question question) {
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
}
