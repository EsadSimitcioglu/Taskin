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

    @PostMapping("/{id}/comments")
    public Comment postCommentToAnswer(@PathVariable Integer id, @RequestBody Comment comment){return answerService.saveNewCommentToAnswer(id,comment.getCommentText(),comment.getCommentWriter());}

    @PutMapping
    public void putAnswer(@RequestBody Answer answer){
        answerService.updateAnswer(answer);
    }

    @PutMapping("/{id}/votes")
    public void putVoteByOneToAnswer(@PathVariable("id") Integer id){
        answerService.addVoteToAnswer(id);
    }

}
