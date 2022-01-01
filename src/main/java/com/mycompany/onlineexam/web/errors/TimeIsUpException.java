package com.mycompany.onlineexam.web.errors;

import org.springframework.http.HttpStatus;
import org.springframework.web.client.HttpClientErrorException;

public class TimeIsUpException extends HttpClientErrorException {

    public TimeIsUpException() {
        super(HttpStatus.LOCKED, "Exam time is up, good luck!");
    }
}
