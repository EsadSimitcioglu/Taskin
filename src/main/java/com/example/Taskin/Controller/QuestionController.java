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

    @GetMapping("/details/{id}")
    public String getQuestionInformationWithQuestionID(@PathVariable("id") Integer id) {return questionService.getQuestionInformationWithQuestionID(id);}

    @PostMapping
    public Integer postQuestion(String questionTitle, String questionDescription,String user, List<QuestionTag> questionTags){
        return questionService.saveNewQuestion(questionTitle,questionDescription,user,questionTags);
    }

    @PostMapping
    public Answer postAnswerToQuestion(Integer questionID, String answerText, String user){
        return questionService.saveNewAnswerToQuestion(questionID,answerText,user);
    }

    @PostMapping
    public Comment postCommentToQuestion(Integer questionID, String commentText, String user){
        return questionService.saveNewCommentToQuestion(questionID,commentText,user);
    }

    @PutMapping("/votes/{id}")
    public void putVoteByOneToQuestion(@PathVariable("id") Integer id){
        questionService.addVoteToAnswer(id);
    }



}
