package com.mycompany.onlineexam.web.errors;

import org.springframework.http.HttpStatus;
import org.springframework.web.client.HttpClientErrorException;

public class IsNotStartTimeException extends HttpClientErrorException {
    public IsNotStartTimeException() {
        super(HttpStatus.CONFLICT , "It is not time to start the exam");
    }
}
