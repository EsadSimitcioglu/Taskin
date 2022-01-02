package com.example.Taskin.Service.Mapper;

import com.example.Taskin.Model.Comment;
import com.example.Taskin.Model.dto.CommentAnswerDTO;
import com.example.Taskin.Model.dto.CommentQuestionDTO;
import org.mapstruct.factory.Mappers;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;


@Mapper
public interface CommentQuestionMapper {

    CommentQuestionMapper INSTANCE = Mappers.getMapper(CommentQuestionMapper.class);

    @Mapping(source = "question.questionID", target = "questionID")
    CommentQuestionDTO commentToQuestionDTO(Comment comment);

}
