package com.example.Taskin.Service;

import com.example.Taskin.Model.Answer;
import com.example.Taskin.Model.Comment;
import com.example.Taskin.Repository.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CommentService {

    @Autowired
    CommentRepository commentRepository;

    // Deleting a specific comment from Question
    public void deleteCommentWithQuestionID(Integer questionID){commentRepository.deleteCommentWithQuestionID(questionID);}

    // Deleting a specific comment from Answer
    public void deleteCommentWithAnswerID(Integer answerID){
        commentRepository.deleteCommentWithAnswerID(answerID);
    }

    // Updating a comment
    public void updateComment(Comment comment){commentRepository.updateComment(comment.getCommentText(),comment.getCommentID());}

    // Voting an answer UI needs to display updated vote count on the screen.
    public void addVoteToComment(Integer commentID){
        commentRepository.updateVoteCountByCommentID(commentID);
    }

}
