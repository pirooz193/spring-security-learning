package com.mycompany.onlineexam.service;

import com.mycompany.onlineexam.domain.Question;

public interface QuestionService {
    Question getQuestionByQuestionCode(String questionCode);
}
