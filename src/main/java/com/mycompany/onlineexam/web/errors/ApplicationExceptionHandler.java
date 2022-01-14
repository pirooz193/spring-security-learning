package com.mycompany.onlineexam.web.errors;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.client.HttpClientErrorException;
import org.zalando.problem.spring.web.advice.ProblemHandling;

@RestControllerAdvice
public class ApplicationExceptionHandler implements ProblemHandling {

    private final Logger logger = LogManager.getLogger(ApplicationExceptionHandler.class);

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ExceptionResponse> handleExceptions(Exception e) {
        ExceptionResponse response = new ExceptionResponse();
        response.setTitle("Action failed");
        response.setDetail(e.getMessage());
        if (e instanceof HttpClientErrorException) {
            response.setStatusCode(((HttpClientErrorException) e).getStatusCode().value());
            response.setDetail(((HttpClientErrorException) e).getStatusText());
        } else if (e instanceof DataIntegrityViolationException) {
            response.setDetail(e.getMessage());
            response.setStatusCode(HttpStatus.BAD_REQUEST.value());
        } else {
            response.setStatusCode(HttpStatus.INTERNAL_SERVER_ERROR.value());
        }
        logger.error(response);
        return ResponseEntity.status(response.getStatusCode()).body(response);
    }

}
