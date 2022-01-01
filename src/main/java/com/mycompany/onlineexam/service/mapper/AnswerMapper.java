package com.mycompany.onlineexam.service.mapper;

import com.mycompany.onlineexam.domain.Answer;
import com.mycompany.onlineexam.service.dto.AnswerDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface AnswerMapper {

    Answer toEntity(AnswerDTO answerDTO);
}
