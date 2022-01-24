package com.mycompany.onlineexam.service;

import com.mycompany.onlineexam.domain.Exam;
import com.mycompany.onlineexam.domain.Student;
import com.mycompany.onlineexam.service.dto.StudentDTO;
import com.mycompany.onlineexam.web.model.QuestionAndAnswerForm;

import java.util.List;

public interface StudentService {
    Student getStudentByUsernameAndPassword(String username, String password);

    Student createStudent(StudentDTO studentDTO);

    List<Student> getAllStudents();

    void deleteStudentByStudentCode(String studentCode);

    Student getStudentByStudentCode(String studentCode);

    Student updateStudent(Student student);

    float checkQuestionAnswers(List<QuestionAndAnswerForm> studentAnswers, Exam exam  , String studentCode);

    Student getStudentByUsername(String username);
}
