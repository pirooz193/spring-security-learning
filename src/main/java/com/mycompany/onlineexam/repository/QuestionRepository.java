package com.mycompany.onlineexam.repository;

import com.mycompany.onlineexam.domain.Question;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface QuestionRepository extends JpaRepository<Question, Long> {

    Question getQuestionByQuestionCode(String questionCode);
    void deleteQuestionByQuestionCode(String questionCode);
}
