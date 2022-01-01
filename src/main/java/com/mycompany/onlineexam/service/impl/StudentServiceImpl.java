package com.mycompany.onlineexam.service.impl;

import com.mycompany.onlineexam.domain.Exam;
import com.mycompany.onlineexam.domain.Question;
import com.mycompany.onlineexam.domain.Student;
import com.mycompany.onlineexam.domain.constants.Constants;
import com.mycompany.onlineexam.repository.StudentRepository;
import com.mycompany.onlineexam.service.ExamService;
import com.mycompany.onlineexam.service.StudentService;
import com.mycompany.onlineexam.service.dto.AnswerDTO;
import com.mycompany.onlineexam.service.dto.StudentDTO;
import com.mycompany.onlineexam.service.mapper.AnswerMapper;
import com.mycompany.onlineexam.service.mapper.StudentMapper;
import com.mycompany.onlineexam.web.mdel.ApiUtil;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {

    private final Logger logger = LogManager.getLogger(StudentServiceImpl.class);
    private final StudentRepository studentRepository;
    private final StudentMapper studentMapper;
    private final ExamService examService;
    private final AnswerMapper answerMapper;

    @Value(value = "${application.constants.student-code-number}")
    private Integer NUMBER_OF_STUDENT_CODE;

    public StudentServiceImpl(StudentRepository studentRepository, StudentMapper studentMapper, ExamService examService, AnswerMapper answerMapper) {
        this.studentRepository = studentRepository;
        this.studentMapper = studentMapper;
        this.examService = examService;
        this.answerMapper = answerMapper;
    }

    @Override
    public Student getStudentByUsernameAndPassword(String username, String password) {
        logger.debug("Request to get student by username:{} and password:{}", username, password);
        return studentRepository.getStudentByUsernameAndPassword(username, password);
    }

    @Override
    public Student createStudent(StudentDTO studentDTO) {
        logger.debug("Request to create an student :{}", studentDTO);
        Student student = studentMapper.toEntity(studentDTO);
        student.setStudentCode(ApiUtil.generateRandomCode(Constants.STUDENT, NUMBER_OF_STUDENT_CODE));
        student.setPassword(studentDTO.getPhoneNumber());
        return studentRepository.save(student);
    }

    @Override
    public List<Student> getAllStudents() {
        logger.debug("Request to get all students in service layer");
        return studentRepository.findAll();
    }

    @Override
    public void deleteStudentByStudentCode(String studentCode) {
        logger.debug("Request to delete student with student-code:{}", studentCode);
        studentRepository.deleteStudentByStudentCode(studentCode);
    }

    @Override
    public Student getStudentByStudentCode(String studentCode) {
        logger.debug("Request to get student by studentCode:{} in service layer", studentCode);
        return studentRepository.getStudentByStudentCode(studentCode);
    }

    @Override
    public Student updateStudent(Student student) {
        logger.debug("Request to update student:{}", student);
        return studentRepository.save(student);
    }

    @Override
    public float checkQuestionAnswers(List<AnswerDTO> answerDTOS, Exam exam, String studentCode) {
        logger.debug("Request to answer questions for exam with exam-code:{} , answers :{} in service layer", exam.getExamCode(), answerDTOS);
        Float examScore = 0f;
        for (Question question : exam.getQuestions()) {
            for (AnswerDTO answerDTO : answerDTOS) {
                if (answerDTO.getContent().equals(question.getCorrectAnswer().getContent())) examScore += question.getScore();
            }
        }
        Student student = studentRepository.getStudentByStudentCode(studentCode);
        exam.getStudentScores().put(student.getId(), examScore);
        examService.update(exam);
        return examScore;
    }

    @Override
    public Student getStudentByUsername(String username) {
        return studentRepository.findStudentByUsername(username);
    }

}
