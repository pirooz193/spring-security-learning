package com.mycompany.onlineexam.web.errors;

public class FullCapacityException extends Throwable {
    public FullCapacityException(String courseTitle) {
        super(courseTitle +" capacity  is full!");
    }
}
