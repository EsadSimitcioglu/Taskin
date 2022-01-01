package com.example.Taskin.Controller;

import com.example.Taskin.Model.Comment;
import com.example.Taskin.Service.CommentService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/comments")
@RestController
public class CommentController {

    @Autowired
    CommentService commentService;

    @DeleteMapping("/{id}/questions")
    @Operation(
            summary = "Delete a comment",
            description = "Remove a comment by question id from the database"
    )
    @ApiResponses(
            value = {
                @ApiResponse(
                        responseCode = "201",
                        description = "Successful operation",
                        content = @Content(schema = @Schema(implementation = Comment.class))
                ),
                @ApiResponse(
                        responseCode = "401",
                        description = "Unsuccessful operation",
                        content = @Content(schema = @Schema(implementation = Comment.class))
                )
            }
    )
    public void deleteCommentWithQuestionIDFromComment(@PathVariable Integer id){commentService.deleteCommentWithQuestionID(id);}


    @DeleteMapping("/{id}/answers")
    @Operation (
            summary = "Delete a comment",
            description = "Remove a comment by answer id from the database"
    )
    @ApiResponses(
            value = {
                @ApiResponse(
                        responseCode = "201",
                        description = "Successful operation",
                        content = @Content(schema = @Schema(implementation = Comment.class))
                ),
                @ApiResponse(
                        responseCode = "401",
                        description = "Unsuccessful operation",
                        content = @Content(schema = @Schema(implementation = Comment.class))
                )
            }
    )
    public void deleteCommentWithAnswerIDFromComment(@PathVariable Integer id){commentService.deleteCommentWithAnswerID(id);}

    @PutMapping
    @Operation (
            summary = "Update a comment",
            description = "Update the content of a comment in the database"
    )
    @ApiResponses(
            value = {
                @ApiResponse(
                        responseCode = "201",
                        description = "Successful operation",
                        content = @Content(schema = @Schema(implementation = Comment.class))
                ),
                @ApiResponse(
                        responseCode = "401",
                        description = "Unsuccessful operation",
                        content = @Content(schema = @Schema(implementation = Comment.class))
                )
            }
    )
    public void putComment(@RequestBody Comment comment){commentService.updateComment(comment);}

    @PutMapping("/{id}/votes")
    public void putVoteByOneToAnswer(@PathVariable("id") Integer id){
        commentService.addVoteToComment(id);
    }

}
