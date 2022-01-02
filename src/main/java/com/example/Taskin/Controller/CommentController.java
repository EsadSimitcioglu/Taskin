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

    @DeleteMapping("/{id}")
    @Operation(
            summary = "Delete a comment",
            description = "Remove a comment by id from the database"
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
    public void deleteCommentWithIDFromComment(@PathVariable Integer id){commentService.deleteCommentWithID(id);}


    @PutMapping(path = "/{id}")
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
    public void putComment(@RequestBody Comment comment, @PathVariable Integer id) {
        commentService.updateComment(comment, id);
    }

    @PutMapping("/{id}/votes/increase")
    public void increaseVoteByOneToAnswer(@PathVariable("id") Integer id){
        commentService.increaseVoteToComment(id);
    }

    @PutMapping("/{id}/votes/decrease")
    public void decreaseVoteByOneToAnswer(@PathVariable("id") Integer id)
    {
        commentService.decreaseVoteToComment(id);
    }

}
