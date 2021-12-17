package com.example.Taskin.Service;


import com.example.Taskin.Model.Answer;
import com.example.Taskin.Model.Question;
import com.example.Taskin.Model.QuestionTag;
import com.example.Taskin.Repository.AnswerRepository;
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

    //Getting all the questions.
    public List<Question> getAllQuestion(){
        return questionRepository.findAll();
    }

    //  return all questions which have those tag.
    public List<Question> getAllQuestionWithTag(String tag){
        return questionRepository.findQuestionWithTags(tag);
    }

    // return all questions which have those tags.
    public List<Question> getAllQuestionWithTags(List<QuestionTag> tags){
        return questionRepository.findQuestionsByQuestionTags(tags);
    }

    // Getting all information about a specific question for displaying question details on the screen
    public String getQuestionInformationWithQuestionID(Integer questionID){
        return questionRepository.getQuestionInformation(questionID);
    }

    // Adding a new question. UI should send question title, question text, tags, and question owner to the backend. UI should get newly added question’s id.
    public Integer saveNewQuestion(Question question){
        questionRepository.save(question);
        return question.getQuestionID();
    }

    public Answer saveNewAnswerToQuestion(String answerText, String user){

        Answer newAnswer = new Answer(answerText,user,new Date());
        answerRepository.save(newAnswer);



    }

}
