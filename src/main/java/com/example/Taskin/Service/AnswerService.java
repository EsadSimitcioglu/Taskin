package com.example.Taskin.Service;

import com.example.Taskin.Model.Answer;
import com.example.Taskin.Model.Comment;
import com.example.Taskin.Repository.AnswerRepository;
import com.example.Taskin.Repository.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.Calendar;

@Service
public class AnswerService {

    @Autowired
    AnswerRepository answerRepository;

    @Autowired
    CommentRepository commentRepository;

    //Adding a new comment for an answer. In addition to the Answer ID, UI should also send the
    //following fields to the back-end application: comment text and user. UI needs newly added
    //comment’s id and related answer’s id.
    public Comment saveNewCommentToAnswer(Integer answerID, String commentText, String user){
        Date date = new Date(Calendar.getInstance().getTime().getTime());
        Answer answer = answerRepository.getById(answerID);
        Comment comment = new Comment(commentText,user,date,answer);
        commentRepository.save(comment);

        return comment;

    }

    // Voting an answer UI needs to display updated vote count on the screen.
    public void addVoteToAnswer(Integer answerID){
        answerRepository.increaseVoteCountByAnswerID(answerID);
    }

    // Voting an answer UI needs to display updated vote count on the screen.
    public void deleteVoteToAnswer(Integer answerID){
        answerRepository.decreaseVoteCountByAnswerID(answerID);
    }

    // Updating an answer
    public void updateAnswer(Answer answer){
        answerRepository.updateAnswer(answer,answer.getAnswerID());
    }






}
