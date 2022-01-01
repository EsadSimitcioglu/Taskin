package com.example.Taskin.Service.Mapper;

import com.example.Taskin.Model.Question;
import com.example.Taskin.Model.dto.QuestionDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface QuestionMapper {
    QuestionMapper INSTANCE = Mappers.getMapper(QuestionMapper.class);

    @Mapping(source = "questionID", target = "id")
    @Mapping(source = "questionTitle", target = "title")
    @Mapping(source = "questionDescription", target = "description")
    @Mapping(source = "user", target = "author")
    @Mapping(source = "date", target = "date")
    @Mapping(source = "questionAnswerCount", target = "answerCount")
    @Mapping(source = "questionViewCount", target = "viewCount")
    @Mapping(source = "questionVoteCount", target = "voteCount")
    @Mapping(source = "questionTags", target = "questionTags")
    QuestionDTO questionToQuestionDTO(Question question);
}
