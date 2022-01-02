package com.example.Taskin.Service.Mapper;

import com.example.Taskin.Model.Answer;
import com.example.Taskin.Model.Comment;
import com.example.Taskin.Model.dto.AnswerQuestionDTO;
import com.example.Taskin.Model.dto.CommentDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface AnswerQuestionMapper {

    AnswerQuestionMapper INSTANCE = Mappers.getMapper(AnswerQuestionMapper.class);

    @Mapping(source = "question.questionID", target = "questionID")
    AnswerQuestionDTO answerToAnswerQuestionDTO(Answer answer);

}
