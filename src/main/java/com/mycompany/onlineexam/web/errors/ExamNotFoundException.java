package com.mycompany.onlineexam.web.errors;

import org.springframework.http.HttpStatus;
import org.springframework.web.client.HttpClientErrorException;

public class ExamNotFoundException extends HttpClientErrorException {
    public ExamNotFoundException(String examCode) {
        super(HttpStatus.NOT_FOUND , "Exam with  exam-code :'" + examCode  +"' not found");
    }
}
