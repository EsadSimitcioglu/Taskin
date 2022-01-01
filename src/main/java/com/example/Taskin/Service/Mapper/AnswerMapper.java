package com.example.Taskin.Service.Mapper;

import com.example.Taskin.Model.Answer;
import com.example.Taskin.Model.dto.AnswerDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface AnswerMapper {
    AnswerMapper INSTANCE = Mappers.getMapper(AnswerMapper.class);


    @Mapping(source = "answerText", target = "answerText")
    @Mapping(source = "answerVoteCount", target = "voteCount")
    @Mapping(source = "answerDate", target = "answerDate")
    @Mapping(source = "user", target = "user")
    @Mapping(source = "question", target = "question")
    AnswerDTO answerToAnswerDto(Answer answer);
}
