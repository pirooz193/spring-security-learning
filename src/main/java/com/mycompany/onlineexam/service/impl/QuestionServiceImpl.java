package com.mycompany.onlineexam.service.impl;

import com.mycompany.onlineexam.domain.Question;
import com.mycompany.onlineexam.repository.QuestionRepository;
import com.mycompany.onlineexam.service.QuestionService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;

@Service
public class QuestionServiceImpl implements QuestionService {

    Logger logger = LogManager.getLogger(QuestionServiceImpl.class);
    private final QuestionRepository questionRepository;

    public QuestionServiceImpl(QuestionRepository questionRepository) {
        this.questionRepository = questionRepository;
    }

    @Override
    public Question getQuestionByQuestionCode(String questionCode) {
        logger.debug("Request to get a question by question-code :{}", questionCode);
        return questionRepository.getQuestionByQuestionCode(questionCode);
    }
}
