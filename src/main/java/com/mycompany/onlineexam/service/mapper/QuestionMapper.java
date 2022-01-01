package com.mycompany.onlineexam.service.mapper;

import com.mycompany.onlineexam.domain.Question;
import com.mycompany.onlineexam.service.dto.QuestionDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring" , uses = {AnswerMapper.class})
public interface QuestionMapper {

    @Mapping(source = "correctAnswerDTO" , target = "correctAnswer")
    @Mapping(source = "answerDTOS" , target = "answers")
    Question toEntity(QuestionDTO questionDTO);
}
