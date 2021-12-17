package com.example.Taskin.Service;


import com.example.Taskin.Model.Answer;
import com.example.Taskin.Model.Comment;
import com.example.Taskin.Model.Question;
import com.example.Taskin.Model.QuestionTag;
import com.example.Taskin.Repository.AnswerRepository;
import com.example.Taskin.Repository.CommentRepository;
import com.example.Taskin.Repository.QuestionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class QuestionService {

    @Autowired
    QuestionRepository questionRepository;

    @Autowired
    AnswerRepository answerRepository;

    @Autowired
    CommentRepository commentRepository;



    //Getting all the questions.
    public List<Question> getAllQuestion(){
        return questionRepository.findAll();
    }

    //  return all questions which have those tag.
    public List<Question> getAllQuestionWithTag(String tag){
        return questionRepository.findQuestionWithTags(tag);
    }

    /*

    // return all questions which have those tags.
    public List<Question> getAllQuestionWithTags(List<QuestionTag> tags){
        return questionRepository.findQuestionsByQuestionTags(tags);
    }

     */

    // Getting all information about a specific question for displaying question details on the screen
    public String getQuestionInformationWithQuestionID(Integer questionID){
        return questionRepository.getQuestionInformation(questionID);
    }

    // Adding a new question. UI should send question title, question text, tags, and question owner to the
    //backend. UI should get newly added question’s id.
    public Integer saveNewQuestion(Question question){
        questionRepository.save(question);
        return question.getQuestionID();
    }

    // Adding a new answer for a question. In addition to the Question ID, UI should also send the following
    //fields to the back-end application: answer text and user. UI needs newly added answer’s id and
    //related question’s id.
    public Answer saveNewAnswerToQuestion(Integer questionID,String answerText, String user){

        Question question = questionRepository.getById(questionID);
        Answer answer = new Answer(answerText,user,new Date(),question);
        answerRepository.save(answer);

        return answer;

    }

    // Adding a new comment for a question. In addition to the Question ID, UI should also send the
    //following fields to the back-end application: comment text and user. UI needs newly added
    //comment’s id and related question’s id.
    public Comment saveNewCommentToQuestion(Integer questionID, String commentText, String user){

        Question question = questionRepository.getById(questionID);
        Comment comment = new Comment(commentText,user,new Date(),question);
        commentRepository.save(comment);

        return comment;

    }

    // Voting a question UI needs to display updated vote count on the screen.
    public Answer addVoteToAnswer(Integer questionID){
        return questionRepository.updateVoteCountByQuestionID(questionID);
    }



}
