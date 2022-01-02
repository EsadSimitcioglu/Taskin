package com.example.Taskin.Controller;

import com.example.Taskin.Model.Answer;
import com.example.Taskin.Model.Comment;
import com.example.Taskin.Model.Question;
import com.example.Taskin.Model.dto.*;
import com.example.Taskin.Service.Mapper.AnswerMapper;
import com.example.Taskin.Service.Mapper.CommentMapper;
import com.example.Taskin.Service.Mapper.QuestionMapper;
import com.example.Taskin.Service.QuestionService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/questions")
@RestController
public class QuestionController {

    @Autowired
    QuestionService questionService;


    @GetMapping
    @Operation (
            summary = "GET questions",
            description = "GET all of the questions"
    )
    @ApiResponses(
            value = {
                @ApiResponse(
                        responseCode = "201",
                        description = "Successful operation",
                        content = @Content(schema = @Schema(implementation = Question.class))
                ),
                @ApiResponse(
                        responseCode = "401",
                        description = "Unsuccessful operation",
                        content = @Content(schema = @Schema(implementation = Question.class))
                )
            }
    )
    public List<QuestionDTO> getAllQuestion() {return questionService.getAllQuestionDTO();}


    @GetMapping("/tags/{questionTags}")
    @Operation (
            summary = "GET questions that have tag",
            description = "GET questions that a have a question tag"
    )
    @ApiResponses(
            value = {
                    @ApiResponse(
                            responseCode = "201",
                            description = "Successful operation",
                            content = @Content(schema = @Schema(implementation = Question.class))
                    ),
                    @ApiResponse(
                            responseCode = "401",
                            description = "Unsuccessful operation",
                            content = @Content(schema = @Schema(implementation = Question.class))
                    )
            }
    )
    public List<QuestionDTO> getAllQuestionWithQuestionTag(@RequestParam List<String> questionTags) {return questionService.getAllQuestionWithTags(questionTags);}

    @GetMapping("/{id}/details")
    @Operation (
            summary = "GET question with ID",
            description = "GET question content with question's ID"
    )
    @ApiResponses(
            value = {
                @ApiResponse(
                        responseCode = "201",
                        description = "Successful operation",
                        content = @Content(schema = @Schema(implementation = Question.class))
                ),
                @ApiResponse(
                        responseCode = "401",
                        description = "Unsuccessful operation",
                        content = @Content(schema = @Schema(implementation = Question.class))
                )
            }
    )
    public String getQuestionInformationWithQuestionID(@PathVariable("id") Integer id) {return questionService.getQuestionInformationWithQuestionID(id);}

    @GetMapping("/votes/{id}")
    public Integer getQuestionVoteCount(@PathVariable("id") Integer id){return questionService.showQuestionVoteCount(id);};

    @PostMapping
    @Operation(
            summary = "Post a question",
            description = "Save new question to database"
    )
    @ApiResponses(
            value = {
                @ApiResponse(
                        responseCode = "201",
                        description = "Successful operation",
                        content = @Content(schema = @Schema(implementation = Question.class))
                ),
                @ApiResponse(
                        responseCode = "401",
                        description = "Unsuccessful operation",
                        content = @Content(schema = @Schema(implementation = Question.class))
                )
            }
    )
    public Integer postQuestion(@RequestBody Question question){
        return questionService.saveNewQuestion(
                question.getQuestionTitle(),
                question.getQuestionDescription(),
                question.getUser().getUserName(),
                question.getQuestionTags()
        );
    }

    @PostMapping("/{id}/answers")
    @Operation (
            summary = "Post an answer to question",
            description = "Save new answer's content for a particular question to database"
    )
    @ApiResponses(
            value = {
                @ApiResponse(
                        responseCode = "201",
                        description = "Successful operation",
                        content = @Content(schema = @Schema(implementation = Question.class))
                ),
                @ApiResponse(
                        responseCode = "401",
                        description = "Unsuccessful operation",
                        content = @Content(schema = @Schema(implementation = Question.class))
                )
            }
    )
    public AnswerQuestionDTO postAnswerToQuestion(@PathVariable Integer id, @RequestBody Answer answer){
        return questionService.saveNewAnswerToQuestionDTO(id,answer.getAnswerText(),answer.getUser().getUserName());
    }

    @PostMapping("/{id}/comments")
    @Operation (
            summary = "Post a comment to question",
            description = "Save new comment's content for a particular question to database"
    )
    @ApiResponses(
            value = {
                @ApiResponse(
                        responseCode = "201",
                        description = "Successful operation",
                        content = @Content(schema = @Schema(implementation = Question.class))
                ),
                @ApiResponse(
                        responseCode = "401",
                        description = "Unsuccessful operation",
                        content = @Content(schema = @Schema(implementation = Question.class))
                )
            }
    )
    public CommentQuestionDTO postCommentToQuestion(@PathVariable Integer id, @RequestBody Comment comment) {
        return questionService.saveNewCommentToQuestionDTO(id, comment.getCommentText(),comment.getUser().getUserName());
    }

    @PutMapping("/{id}/votes/increases")
    @Operation (
            summary = "Update a vote",
            description = "Update vote count for an answer"
    )
    @ApiResponses(
            value = {
                @ApiResponse(
                        responseCode = "202",
                        description = "Successful operation",
                        content = @Content(schema = @Schema(implementation = Question.class))
                ),
                @ApiResponse(
                        responseCode = "401",
                        description = "Unsuccessful operation",
                        content = @Content(schema = @Schema(implementation = Question.class))
                )
            }
    )
    public void putIncreaseVoteToQuestion(@PathVariable("id") Integer id){
        questionService.addVoteToQuestion(id);
    }

    @PutMapping("/{id}/votes/decreases")
    @Operation (
            summary = "Update a vote",
            description = "Update vote count for an answer"
    )
    @ApiResponses(
            value = {
                @ApiResponse(
                        responseCode = "202",
                        description = "Successful operation",
                        content = @Content(schema = @Schema(implementation = Question.class))
                ),

                @ApiResponse(
                        responseCode = "401",
                        description = "Unsuccessful operation",
                        content = @Content(schema = @Schema(implementation = Question.class))
                )
            }
    )
    public void putDecreaseVoteToQuestion(@PathVariable("id") Integer id){
        questionService.removeVoteFromQuestion(id);
    }
}
