package com.example.Taskin.Controller;

import com.example.Taskin.Model.Comment;
import com.example.Taskin.Service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/comments")
@RestController
public class CommentController {

    @Autowired
    CommentService commentService;

    @DeleteMapping("/{id}/questions")
    public void deleteCommentWithQuestionIDFromComment(@PathVariable Integer id){commentService.deleteCommentWithQuestionID(id);}

    @DeleteMapping("/{id}/answers")
    public void deleteCommentWithAnswerIDFromComment(@PathVariable Integer id){commentService.deleteCommentWithAnswerID(id);}

    @PutMapping
    public void putComment(@RequestBody Comment comment){commentService.updateComment(comment);}

}
