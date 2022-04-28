package com.mycompany.onlineexam.web.errors;

import org.springframework.http.HttpStatus;
import org.springframework.web.client.HttpClientErrorException;

/**
 * User: Pirooz
 * Date : 4/27/2022
 * Time : 12:41 PM
 */
public class CourseListIsEmptyException extends HttpClientErrorException {

    public CourseListIsEmptyException() {
        super(HttpStatus.NOT_FOUND, "No course found");
    }
}
