package com.mycompany.onlineexam.web.rest;

import com.mycompany.onlineexam.domain.Exam;
import com.mycompany.onlineexam.service.ExamService;
import com.mycompany.onlineexam.service.dto.ExamDTO;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/api/exam")
public class ExamResource {

    private Logger logger = LogManager.getLogger(ExamResource.class);

    private final ExamService examService;

    public ExamResource(ExamService examService) {
        this.examService = examService;
    }

    @PostMapping("/create-exam")
    public ResponseEntity<Exam> createExam(@RequestBody ExamDTO examDTO) {
        logger.info("Request to create an Exam :{}", examDTO);
        Exam exam = examService.save(examDTO);
        return ResponseEntity.created(URI.create("/create")).body(exam);
    }

    @GetMapping("/get-all")
    public ResponseEntity<List<Exam>> getAllExams() {
        logger.info("Request to get all Exams");
        List<Exam> exams = examService.getAllExams();
        return ResponseEntity.ok(exams);
    }

    @DeleteMapping("/delete-exam")
    public ResponseEntity<Void> deleteExam(@RequestParam String examCode) {
        logger.info("Request to delete an Exam with exam-code :{}", examCode);
        examService.deleteExamByExamCode(examCode);
        return (ResponseEntity<Void>) ResponseEntity.ok();
    }

    @DeleteMapping("/delete-question")
    public ResponseEntity<Void> deleteQuestion(@RequestParam String questionCode, @RequestParam String examCode) {
        logger.info("Request to delete Exam's question with question-code :{}", questionCode);
        examService.deleteQuestion(questionCode, examCode);
        return (ResponseEntity<Void>) ResponseEntity.ok();
    }

    @GetMapping("/exam-info")
    public ResponseEntity<Exam> takeTest(@RequestParam String examCode) {
        logger.info("Request to check exam with exam-code :{}", examCode);
        Exam exam = examService.getExamByExamCode(examCode);
//            examService.checkExamTime(exam);
        return ResponseEntity.ok(exam);
    }

    @GetMapping("/remaining-time")
    public ResponseEntity<Long> getExamRemainingTime(@RequestParam String examCode) {
        logger.info("Request to get Exam remaining time with exam-code:{}", examCode);
        Long remainingTime = examService.checkExamRemainingTime(examCode);
        return ResponseEntity.ok(remainingTime);
    }

    @GetMapping("/get-exam-by-student")
    public ResponseEntity<Exam> getExamQuestions(@RequestParam String examCode) {
        logger.info("Request to show exam questions by  exam-code :{}", examCode);
        Exam exam = examService.getExamByExamCode(examCode);
        examService.checkExamTime(exam);
        return ResponseEntity.ok(exam);
    }

    @PutMapping("/update-time")
    public ResponseEntity<ExamDTO> updateExamTime(@RequestParam String examCode,
                                                  @RequestParam String startTime,
                                                  @RequestParam String endTime) {
        logger.debug("Request to update time of exam : {}, start-time:{} and end-time :{}", examCode, startTime, endTime);

        ExamDTO examDTO = examService.updateExamStartAndEndTime(examCode,LocalDateTime.parse(startTime), LocalDateTime.parse(endTime));
        return ResponseEntity.ok(examDTO);
    }
}
