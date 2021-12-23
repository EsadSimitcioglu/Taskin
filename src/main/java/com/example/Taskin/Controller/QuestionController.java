package com.example.Taskin.Controller;

import com.example.Taskin.Model.Answer;
import com.example.Taskin.Model.Comment;
import com.example.Taskin.Model.Question;
import com.example.Taskin.Model.QuestionTag;
import com.example.Taskin.Service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RequestMapping("/questions")
@RestController
public class QuestionController {

    @Autowired
    QuestionService questionService;


    @GetMapping
    public List<Question> getAllQuestion() {return questionService.getAllQuestion();}

    @GetMapping("/tag/{questionTag}")
    public List<Question> getAllQuestionWithQuestionTag(@PathVariable("questionTag") String questionTag) {return questionService.getAllQuestionWithTag(questionTag);}

    @GetMapping("/{id}/details")
    public String getQuestionInformationWithQuestionID(@PathVariable("id") Integer id) {return questionService.getQuestionInformationWithQuestionID(id);}

    @PostMapping
    public Integer postQuestion(@RequestBody Question question){
        return questionService.saveNewQuestion(question.getQuestionTitle(),question.getQuestionDescription(),question.getQuestionAskedFrom(),question.getQuestionTags());
    }

    @PostMapping("/{id}/answers")
    public Answer postAnswerToQuestion(@PathVariable Integer id, @RequestBody Answer answer){
        return questionService.saveNewAnswerToQuestion(id,answer.getAnswerText(),answer.getAnswerFrom());
    }

    @PostMapping("/{id}/comments")
    public Comment postCommentToQuestion(@PathVariable Integer id, @RequestBody Comment comment){
        return questionService.saveNewCommentToQuestion(id,comment.getCommentText(),comment.getCommentWriter());
    }

    @PutMapping("/{id}/votes/increases")
    public void putIncreaseVoteToAnswer(@PathVariable("id") Integer id){
        questionService.addVoteToAnswer(id);
    }

    @PutMapping("/{id}/votes/decreases")
    public void putDecreaseVoteToAnswer(@PathVariable("id") Integer id){
        questionService.removeVoteToAnswer(id);
    }


}
