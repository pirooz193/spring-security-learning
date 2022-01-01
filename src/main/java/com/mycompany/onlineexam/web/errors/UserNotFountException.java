package com.mycompany.onlineexam.web.errors;

import org.springframework.http.HttpStatus;
import org.springframework.web.client.HttpClientErrorException;

public class UserNotFountException extends HttpClientErrorException {
    public UserNotFountException(String user) {
        super(HttpStatus.NOT_FOUND, user + " not found");
    }
}
