package com.mycompany.onlineexam.web.errors;

import org.springframework.http.HttpStatus;
import org.springframework.web.client.HttpClientErrorException;

public class StudentListEmptyException extends HttpClientErrorException {
    public StudentListEmptyException() {
        super(HttpStatus.NOT_FOUND , "There is not any student, yet");
    }
}
