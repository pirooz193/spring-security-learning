package com.mycompany.onlineexam.web.errors;

import org.springframework.http.HttpStatus;
import org.springframework.web.client.HttpClientErrorException;
import org.zalando.problem.Status;

public class UnAuthorizedException extends HttpClientErrorException {
    public UnAuthorizedException() {
        super(HttpStatus.UNAUTHORIZED);
    }
}
