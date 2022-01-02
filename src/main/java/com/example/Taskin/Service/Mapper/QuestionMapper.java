package com.example.Taskin.Service.Mapper;

import com.example.Taskin.Model.Question;
import com.example.Taskin.Model.dto.QuestionDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface QuestionMapper {
    QuestionMapper INSTANCE = Mappers.getMapper(QuestionMapper.class);

    @Mapping(source = "questionTitle", target = "title")
    @Mapping(source = "questionDescription", target = "description")
    @Mapping(source = "user", target = "author")
    @Mapping(source = "questionAskedDate", target = "date")
    @Mapping(source = "questionVoteCount", target = "voteCount")
    QuestionDTO questionToQuestionDTO(Question question);

    @Mapping(source = "title", target = "questionTitle")
    @Mapping(source = "description", target = "questionDescription")
    @Mapping(source = "author", target = "user")
    @Mapping(source = "date", target = "questionAskedDate")
    @Mapping(source = "voteCount", target = "questionVoteCount")
    Question questionDTOToQuestion(QuestionDTO questionDTO);

}
