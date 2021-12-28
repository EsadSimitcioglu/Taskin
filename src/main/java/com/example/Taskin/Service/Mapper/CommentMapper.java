package com.example.Taskin.Service.Mapper;

import com.example.Taskin.Model.Comment;
import com.example.Taskin.Model.dto.CommentDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface CommentMapper {
    CommentMapper INSTANCE = Mappers.getMapper(CommentMapper.class);


    @Mapping(source = "commentText", target = "text")
    @Mapping(source = "user", target = "author")
    @Mapping(source = "commentDate", target = "date")
    @Mapping(source = "question", target = "question")
    @Mapping(source = "answer", target = "answer")
    CommentDTO commentToCommentDTO(Comment comment);
}
