package com.mycompany.onlineexam.service.impl;

import com.mycompany.onlineexam.domain.*;
import com.mycompany.onlineexam.repository.*;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

@SpringBootTest
class CourseServiceImplTest {

    @Autowired
    CourseRepository courseRepository;

    @Autowired
    StudentRepository studentRepository;
    @Autowired
    MasterRepository masterRepository;
    @Autowired
    ExamRepository examRepository;
    @Autowired
    RoleRepository roleRepository;

    @Test
    void createCourse() {
        setUp();
        Course course = new Course();
        course.setCourseTitle("test course");
        course.setCourseCode("test-course-code");
        course.setCourseCapacity(2);
        Student student = studentRepository.findStudentByUsername("student");
        Master master = masterRepository.findMasterByUsername("master");
        Exam exam = getExam();
        course.setMaster(master);
        course.setStudents(Collections.singleton(student));
        course.getExamList().add(exam);
        courseRepository.save(course);
    }

    private Exam getExam() {
        Exam exam = createExam();
        Question question = createQuestion("q1", 42);

        Answer answer1 = new Answer();
        answer1.setContent("answer1");
        Answer answer2 = new Answer();
        answer2.setContent("answer2");
        Answer answer3 = new Answer();
        answer3.setContent("answer3");
        Answer answer4 = new Answer();
        answer4.setContent("answer4");

        Set<Answer> answers = new HashSet<>();
        answers.add(answer1);
        answers.add(answer2);
        answers.add(answer3);
        answers.add(answer4);

        question.setQuestionCode("q1-code");
        question.setCorrectAnswer(answer4);
        question.setAnswers(answers);

        Question question2 = createQuestion("q2", 30f);

        Answer q2Answer1 = new Answer();
        q2Answer1.setContent("answer1");
        Answer q2Answer2 = new Answer();
        q2Answer2.setContent("answer2");
        Answer q2Answer3 = new Answer();
        q2Answer3.setContent("answer3");
        Answer q2Answer4 = new Answer();
        q2Answer4.setContent("answer4");

        Set<Answer> q2Answers = new HashSet<>();
        q2Answers.add(q2Answer1);
        q2Answers.add(q2Answer2);
        q2Answers.add(q2Answer3);
        q2Answers.add(q2Answer4);

        question2.setQuestionCode("q2-code");
        question2.setCorrectAnswer(q2Answer4);
        question2.setAnswers(q2Answers);


        exam.getQuestions().add(question);
        exam.getQuestions().add(question2);
        return exam;
    }

    private void setUp() {
        Student student = new Student();
        student.setUsername("student");
        student.setPassword("student");
        student.setPhoneNumber("09118249965");
        student.setStudentCode("sample_student_code");
        student.setRoles(Collections.emptyList());
        studentRepository.save(student);

        Master master = new Master();
        master.setMasterCode("master-code");
        master.setPhoneNumber("09118249963");
        master.setUsername("master");
        master.setPassword("master");
        master.getRoles().add(roleRepository.save(new Role("ROLE_MASTER")));
    }


    private Question createQuestion(String title, float score) {
        Question question = new Question();
        question.setQuestionTitle(title);
        question.setScore(score);
        return question;
    }

    private Exam createExam() {
        Exam exam = new Exam();
        exam.setExamTitle("test Exam");
        exam.setStartDateTime(LocalDateTime.of(LocalDate.of(2022, 1, 23), LocalTime.of(10, 8)));
        exam.setEndDateTime(LocalDateTime.of(LocalDate.of(2022, 1, 23), LocalTime.of(10, 30)));
        exam.setExamCode("Exam-sample-code");
        exam.setExamScore(100f);
        return exam;
    }

    @Test
    void addStudentToCourse() {
    }

    @Test
    void addMasterToCourse() {
    }

    @Test
    void getCourseByCourseCode() {
    }

    @Test
    void getAllCourses() {
    }
}