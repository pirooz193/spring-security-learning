package com.mycompany.onlineexam.web.errors;

import org.springframework.http.HttpStatus;
import org.springframework.web.client.HttpClientErrorException;

public class NotFoundErrorException extends HttpClientErrorException {
    public NotFoundErrorException(String user, String code) {
        super(HttpStatus.NOT_FOUND, user + " with " + user + "-code : " + code + " Not Found");
    }
}
