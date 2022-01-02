package com.example.Taskin.Service;

import com.example.Taskin.Model.Comment;
import com.example.Taskin.Repository.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CommentService {

    @Autowired
    CommentRepository commentRepository;

    // Deleting a specific comment from Question
    public void deleteCommentWithID(Integer ID) {
        commentRepository.deleteCommentWithID(ID);
    }

    // Updating a comment
    public void updateComment(Comment comment, Integer id) {
        commentRepository.updateComment(comment.getCommentText(), id);
    }

    // Voting an answer UI needs to display updated vote count on the screen.
    public void increaseVoteToComment(Integer commentID){
        commentRepository.increaseVoteCountByCommentID(commentID);
    }

    public void decreaseVoteToComment(Integer commentID){
        commentRepository.decreaseVoteCountByCommentID(commentID);
    }

}
