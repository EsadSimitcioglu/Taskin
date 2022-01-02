package com.example.Taskin.Service.Mapper;

import com.example.Taskin.Model.Answer;
import com.example.Taskin.Model.Comment;
import com.example.Taskin.Model.dto.AnswerQuestionDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import com.example.Taskin.Model.dto.CommentAnswerDTO;
import org.mapstruct.factory.Mappers;

@Mapper
public interface CommentAnswerMapper {

    CommentAnswerMapper INSTANCE = Mappers.getMapper(CommentAnswerMapper.class);

    @Mapping(source = "answer.answerID", target = "answerID")
    CommentAnswerDTO commentToCommentAnswerDTO(Comment comment);

}
