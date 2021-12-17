package com.example.Taskin.Controller;


import com.example.Taskin.Model.Answer;
import com.example.Taskin.Model.Comment;
import com.example.Taskin.Service.AnswerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/answers")
@RestController
public class AnswerController {

    @Autowired
    AnswerService answerService;

    @PostMapping
    public Comment postCommentToAnswer(Integer answerID, String commentText, String user){
        return answerService.saveNewCommentToAnswer(answerID,commentText,user);
    }

    @PutMapping("/votes/{id}")
    public void putVoteByOneToAnswer(@PathVariable("id") Integer id){
        answerService.addVoteToAnswer(id);
    }

    @PutMapping
    public void putVoteByOneToAnswer(@RequestBody Answer answer){
        answerService.updateAnswer(answer);
    }

}
