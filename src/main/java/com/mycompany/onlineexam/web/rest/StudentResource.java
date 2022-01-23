package com.mycompany.onlineexam.web.rest;

import com.mycompany.onlineexam.domain.Exam;
import com.mycompany.onlineexam.domain.Student;
import com.mycompany.onlineexam.domain.constants.Constants;
import com.mycompany.onlineexam.service.ExamService;
import com.mycompany.onlineexam.service.StudentService;
import com.mycompany.onlineexam.service.dto.AnswerDTO;
import com.mycompany.onlineexam.service.dto.StudentDTO;
import com.mycompany.onlineexam.web.errors.NotFoundErrorException;
import com.mycompany.onlineexam.web.errors.StudentListEmptyException;
import com.mycompany.onlineexam.web.errors.UserNotFountException;
import com.mycompany.onlineexam.web.mdel.ApiUtil;
import com.mycompany.onlineexam.web.mdel.QuestionAndAnswerForm;
import com.mycompany.onlineexam.web.mdel.ServiceResult;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.HttpClientErrorException;
import org.zalando.problem.Status;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api")
public class StudentResource {

    private final Logger logger = LogManager.getLogger(StudentResource.class);

    private final StudentService studentService;
    private final ExamService examService;

    public StudentResource(StudentService studentService, ExamService examService) {
        this.studentService = studentService;
        this.examService = examService;
    }

    @GetMapping("/student/login")
    public ResponseEntity<Student> loginStudent(@RequestParam String username, @RequestParam String password) {
        logger.info("Request to check student login with username:{} and password :{}", username, password);
        Student student = studentService.getStudentByUsernameAndPassword(username, password);
        if (student == null) throw new UserNotFountException(Constants.STUDENT);
        return ResponseEntity.ok(student);
    }

    @PostMapping("/admin/create-student")
    public ResponseEntity<Student> createStudent(@RequestBody StudentDTO studentDTO) {
        logger.info("Request to create an student :{}", studentDTO);
        Student student = studentService.createStudent(studentDTO);
        return ResponseEntity.created(URI.create("/admin/create-student")).body(student);
    }

    @GetMapping("/admin/get-student/{studentCode}")
    public ResponseEntity<Student> getStudentByStudentCode(@PathVariable String studentCode) {
        logger.info("Request to get sn Student by  student-code :{}", studentCode);
        Student student = studentService.getStudentByStudentCode(studentCode);
        if (student == null) throw new NotFoundErrorException("student", studentCode);
        return ResponseEntity.ok().body(student);
    }

    @GetMapping("/admin/get-all-students")
    public ResponseEntity<List<Student>> getAllStudents() {
        logger.info("Request to get all students");
        List<Student> students = studentService.getAllStudents();
        if (students.isEmpty()) throw new StudentListEmptyException();
        return ResponseEntity.ok(students);
    }

    @DeleteMapping("/admin/delete-student/{studentCode}")
    public void deleteStudent(@PathVariable String studentCode) {
        logger.info("Request to delete student with id :{}", studentCode);
        studentService.deleteStudentByStudentCode(studentCode);
    }

    @PostMapping("/student/answer-questions")
    public ResponseEntity<Float> answerQuestions(@RequestBody List<QuestionAndAnswerForm> studentAnswers,
                                                 @RequestParam String examCode,
                                                 @RequestParam String studentCode) {
        logger.info("Request to answer questions for exam with exam-code:{} , answers :{}", examCode, studentAnswers);
        examService.checkExamRemainingTime(examCode);
//            examService.checkExamTime(exam);
        Exam exam = examService.getExamByExamCode(examCode);
        float studentScore = studentService.checkQuestionAnswers(studentAnswers, exam, studentCode);
        return ResponseEntity.ok(studentScore);
    }

    @GetMapping("/student/take-exam")
    public ResponseEntity<ServiceResult> takeTest(@RequestParam String examCode, @RequestParam String studentCode) {
        logger.info("Request to take exam for exam with exam-code :{} and student-code :{}", examCode, studentCode);
        ServiceResult serviceResult;
        Integer statusCode;
        try {
            studentService.deleteStudentByStudentCode(studentCode);
            serviceResult = ApiUtil.getServiceResult(null, Constants.SUCCESSFULLY_DONE, Status.OK.getStatusCode());
        } catch (Exception e) {
            logger.error("Action failed, caused by :{}", e.getMessage(), e);
            if (e instanceof HttpClientErrorException)
                statusCode = ((HttpClientErrorException) e).getStatusCode().value();
            else statusCode = Status.INTERNAL_SERVER_ERROR.getStatusCode();
            serviceResult = ApiUtil.getServiceResult(null, e.getMessage(), statusCode);
        }
        return ResponseEntity.status(serviceResult.getStatusCode()).body(serviceResult);
    }

}
