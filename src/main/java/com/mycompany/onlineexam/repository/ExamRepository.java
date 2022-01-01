package com.mycompany.onlineexam.repository;

import com.mycompany.onlineexam.domain.Exam;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ExamRepository extends JpaRepository<Exam, Long> {

    Exam getExamByExamCode(String examCode);
    void deleteExamByExamCode(String examCode);
}
