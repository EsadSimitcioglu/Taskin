package com.example.Taskin.Controller;


import com.example.Taskin.Model.Answer;
import com.example.Taskin.Model.Comment;
import com.example.Taskin.Model.dto.CommentDTO;
import com.example.Taskin.Service.AnswerService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/answers")
@RestController
public class AnswerController {

    @Autowired
    AnswerService answerService;

    @GetMapping("/votes/{id}")
    public Integer getAnswersVoteCount(@PathVariable("id") Integer id){return answerService.showAnswerVoteCount(id);};

    @PostMapping("/{id}/comments")
    @Operation (summary = "Post a comment",
                description = "Save new comment's content to database")
        @ApiResponses(value = {
                @ApiResponse(responseCode = "201",
                            description = "Successful operation"),
                @ApiResponse(responseCode = "401",
                        description = "Unsuccessful operation")})
    public CommentDTO postCommentToAnswer(@PathVariable Integer id, @RequestBody Comment comment){return answerService.saveNewCommentToAnswer(id,comment.getCommentText(),comment.getUser().getUserName());}


    @Operation (summary = "Update an answer",
            description = "Update answer's content to new values")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "202",
                    description = "Successful operation"),
            @ApiResponse(responseCode = "401",
                    description = "Unsuccessful operation")})
    @PutMapping
    public void putAnswer(@RequestBody Answer answer){
        answerService.updateAnswer(answer);
    }

    @Operation (summary = "Upvote an answer",
            description = "Increase the positive vote count of an answer")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "204",
                    description = "Successful operation"),
            @ApiResponse(responseCode = "401",
                    description = "Unsuccessful operation")})
    @PutMapping("/{id}/votes/increases")
    public void putIncreaseVoteToAnswer(@PathVariable("id") Integer id){
        answerService.addVoteToAnswer(id);
    }

    @Operation (summary = "Down-vote an answer",
            description = "Increase the positive vote count of an answer")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "204",
                    description = "Successful operation"),
            @ApiResponse(responseCode = "401",
                    description = "Unsuccessful operation")})
    @PutMapping("/{id}/votes/decreases")
    public void putDecreaseVoteToAnswer(@PathVariable("id") Integer id){
        answerService.removeVoteFromAnswer(id);
    }

}
