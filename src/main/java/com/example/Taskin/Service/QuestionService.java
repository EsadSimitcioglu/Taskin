package com.example.Taskin.Service;
import com.example.Taskin.Model.*;
import com.example.Taskin.Model.dto.*;
import com.example.Taskin.Repository.AnswerRepository;
import com.example.Taskin.Repository.CommentRepository;
import com.example.Taskin.Repository.QuestionRepository;
import com.example.Taskin.Repository.UserRepository;
import com.example.Taskin.Service.Mapper.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.List;

@Service
public class QuestionService {

    @Autowired
    QuestionRepository questionRepository;

    @Autowired
    AnswerRepository answerRepository;

    @Autowired
    CommentRepository commentRepository;

    @Autowired
    UserRepository userRepository;


    //Getting all the questions
    public List<QuestionDTO> getAllQuestionDTO() {
        List<QuestionDTO> listDto = new ArrayList<>();
        List<Question> list = questionRepository.findAll();

        list.forEach(question -> {
            QuestionDTO dto = QuestionMapper.INSTANCE.questionToQuestionDTO(question);
            listDto.add(dto);
        });

        return listDto;
    }

    //  return all questions which have those tag.
    public List<QuestionDTO> getAllQuestionWithTags(List<String> tags){
        List<QuestionDTO> listDto = new ArrayList<>();
        List<Question> list = questionRepository.getQuestionByQuestionTagsIn(tags);

        list.forEach(question -> {
            QuestionDTO dto = QuestionMapper.INSTANCE.questionToQuestionDTO(question);
            listDto.add(dto);
        });
        return listDto;
    }

    // Getting all information about a specific question for displaying question details on the screen
    public String getQuestionInformationWithQuestionID(Integer questionID){
        return questionRepository.getQuestionInformation(questionID);
    }

    // Adding a new question. UI should send question title, question text, tags, and question owner to the
    //backend. UI should get newly added question’s id.
    public Integer saveNewQuestion(String questionTitle, String questionDescription, String username, List<QuestionTag> questionTags) {
        Date date = new Date(Calendar.getInstance().getTime().getTime());
        Users user = userRepository.getUserByUserName(username);
        Question question = new Question(questionTitle,questionDescription,user,date,questionTags);
        questionRepository.save(question);
        return question.getQuestionID();
    }

    // Adding a new answer for a question. In addition to the Question ID, UI should also send the following
    //fields to the back-end application: answer text and user. UI needs newly added answer’s id and
    //related question’s id.
    public AnswerQuestionDTO saveNewAnswerToQuestionDTO(Integer questionID, String answerText, String username) {
        Date date = new Date(Calendar.getInstance().getTime().getTime());
        Users user = userRepository.getUserByUserName(username);
        Question question = questionRepository.getById(questionID);
        Answer answer = new Answer(answerText, user, date, question);

        if(user.equals(question.getUser()))
            return null;
        else {
            answerRepository.save(answer);
            return  AnswerQuestionMapper.INSTANCE.answerToAnswerQuestionDTO(answer);
        }
    }

    // Adding a new comment for a question. In addition to the Question ID, UI should also send the
    //following fields to the back-end application: comment text and user. UI needs newly added
    //comment’s id and related question’s id.
    public CommentQuestionDTO saveNewCommentToQuestionDTO(Integer questionID, String commentText, String username){
        Date date = new Date(Calendar.getInstance().getTime().getTime());
        Users user = userRepository.getUserByUserName(username);
        Question question = questionRepository.getById(questionID);
        Comment comment = new Comment(commentText,user,date, question);
        commentRepository.save(comment);

        return CommentQuestionMapper.INSTANCE.commentToQuestionDTO(comment);

    }

    // Voting a question UI needs to display updated vote count on the screen.
    public void addVoteToQuestion(Integer questionID){
        questionRepository.increaseVoteCountByQuestionID(questionID);
    }

    // Voting a question UI needs to display updated vote count on the screen.
    public void removeVoteFromQuestion(Integer questionID){
        questionRepository.decreaseVoteCountByQuestionID(questionID);
    }

    // Display the question's vote count
    public Integer showQuestionVoteCount(Integer questionID) {return questionRepository.getAllQuestionVoteCount(questionID);}

    // Display all comments for a spesific question
    public CommentDTO getCommentsFromQuestion(Integer questionID){
        List<CommentDTO> listDto = new ArrayList<>();
        List<Comment> comments = questionRepository.getCommentsWithQuestionID(questionID);

        comments.forEach(comment -> {
            CommentDTO dto =  CommentMapper.INSTANCE.commentToCommentDTO(comment);
            listDto.add(dto);
        });
        return (CommentDTO) listDto;
    }
}
