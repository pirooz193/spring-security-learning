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
public class OnlineExamExceptionTranslator implements ProblemHandling {
    private Logger logger = LogManager.getLogger(OnlineExamExceptionTranslator.class);

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ExceptionResponse> handleExceptions(Exception e) {
        logger.error("Action failed, caused by : {}", e.getCause(), e);
        HttpStatus status;
        if (e instanceof HttpClientErrorException) status = ((HttpClientErrorException) e).getStatusCode();
        else if (e instanceof DataIntegrityViolationException) status = HttpStatus.BAD_REQUEST;
        else status = HttpStatus.INTERNAL_SERVER_ERROR;
        return new ResponseEntity<>(
                new ExceptionResponse(status.getReasonPhrase(), e.getMessage(), status.value())
                , status);
    }

}
