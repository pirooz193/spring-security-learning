package com.mycompany.onlineexam.web.errors;

public class StudentExistenceException extends Exception {
    public StudentExistenceException(String studentCode) {
        super(" student with this student-code :{ " + studentCode + "} has exist in course");
    }
}
