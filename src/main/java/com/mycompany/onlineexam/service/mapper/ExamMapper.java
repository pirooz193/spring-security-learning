package com.mycompany.onlineexam.service.mapper;

import com.mycompany.onlineexam.domain.Exam;
import com.mycompany.onlineexam.service.dto.ExamDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", uses = {AnswerMapper.class, QuestionMapper.class})
public interface ExamMapper {

    @Mapping(source = "examDTO.questionDTOS", target = "questions")
    Exam toEntity(ExamDTO examDTO);

    @Mapping(source = "savedExam.questions", target = "questionDTOS")
    ExamDTO toDTO(Exam savedExam);
}
