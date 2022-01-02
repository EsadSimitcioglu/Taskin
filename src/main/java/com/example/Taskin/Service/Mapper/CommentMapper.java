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
	@Mapping(source = "commentDate", target = "date")
	CommentDTO commentToCommentDTO(Comment comment);

	@Mapping(source = "text", target = "commentText")
	@Mapping(source = "date", target = "commentDate")
	Comment commentDTOToComment(CommentDTO commentDTO);
}
