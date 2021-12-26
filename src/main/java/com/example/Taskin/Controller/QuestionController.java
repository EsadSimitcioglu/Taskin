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

    @GetMapping("/tag")
    public List<Question> getAllQuestionWithQuestionTag(@RequestBody List<QuestionTag> questionTags) {return questionService.getAllQuestionWithTags(questionTags);}

    @GetMapping("/{id}/details")
    public String getQuestionInformationWithQuestionID(@PathVariable("id") Integer id) {return questionService.getQuestionInformationWithQuestionID(id);}

    @GetMapping("/votes/{id}")
    public Integer getQuestionVoteCount(@PathVariable("id") Integer id){return questionService.showQuestionVoteCount(id);};

    @PostMapping
    public Integer postQuestion(@RequestBody Question question){
        return questionService.saveNewQuestion(question.getQuestionTitle(),question.getQuestionDescription(),question.getUser().getUserName(),question.getQuestionTags());
    }

    @PostMapping("/{id}/answers")
    public Answer postAnswerToQuestion(@PathVariable Integer id, @RequestBody Answer answer){
        return questionService.saveNewAnswerToQuestion(id,answer.getAnswerText(),answer.getUser().getUserName());
    }

    @PostMapping("/{id}/comments")
    public Comment postCommentToQuestion(@PathVariable Integer id, @RequestBody Comment comment){
        return questionService.saveNewCommentToQuestion(id,comment.getCommentText(),comment.getUser().getUserName());
    }

    @PutMapping("/{id}/votes/increases")
    public void putIncreaseVoteToAnswer(@PathVariable("id") Integer id){
        questionService.addVoteToQuestion(id);
    }

    @PutMapping("/{id}/votes/decreases")
    public void putDecreaseVoteToAnswer(@PathVariable("id") Integer id){
        questionService.removeVoteFromQuestion(id);
    }


}
