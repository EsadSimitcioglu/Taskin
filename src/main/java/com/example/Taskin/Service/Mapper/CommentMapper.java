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
	@Mapping(source = "commentVoteCount", target = "voteCount")
	CommentDTO commentToCommentDTO(Comment comment);

	@Mapping(source = "text", target = "commentText")
	@Mapping(source = "date", target = "commentDate")
	@Mapping(source = "voteCount", target = "commentVoteCount")
	Comment commentDTOToComment(CommentDTO commentDTO);
}
