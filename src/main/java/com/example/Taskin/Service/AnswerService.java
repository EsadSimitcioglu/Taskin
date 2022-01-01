package com.example.Taskin.Service;

import com.example.Taskin.Model.Answer;
import com.example.Taskin.Model.Comment;
import com.example.Taskin.Model.Users;
import com.example.Taskin.Model.dto.CommentDTO;
import com.example.Taskin.Repository.AnswerRepository;
import com.example.Taskin.Repository.CommentRepository;
import com.example.Taskin.Repository.UserRepository;
import com.example.Taskin.Service.Mapper.CommentMapper;
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

    @Autowired
    UserRepository userRepository;

    //Adding a new comment for an answer. In addition to the Answer ID, UI should also send the
    //following fields to the back-end application: comment text and user. UI needs newly added
    //comment’s id and related answer’s id.
    public CommentDTO saveNewCommentToAnswer(Integer answerID, String commentText, String username){

        Users user = userRepository.getUserByUserName(username);
        Answer answer = answerRepository.getById(answerID);

        if(user.equals(answer.getUser()))
            return null;

        else{
            Date date = new Date(Calendar.getInstance().getTime().getTime());
            Comment comment = new Comment(commentText,user,date,answer);
            commentRepository.save(comment);
            return CommentMapper.INSTANCE.commentToCommentDTO(comment);
        }
    }

    // Voting an answer UI needs to display updated vote count on the screen.
    public void addVoteToAnswer(Integer answerID){
        answerRepository.increaseVoteCountByAnswerID(answerID);
    }

    // Voting an answer UI needs to display updated vote count on the screen.
    public void removeVoteFromAnswer(Integer answerID){
        answerRepository.decreaseVoteCountByAnswerID(answerID);
    }

    // Updating an answer
    public void updateAnswer(Answer answer){
        answerRepository.updateAnswer(answer,answer.getAnswerID());
    }

    // Display the answer's vote count
    public Integer showAnswerVoteCount(Integer answerID) {return answerRepository.getAllAnswerVoteCount(answerID);}

}
