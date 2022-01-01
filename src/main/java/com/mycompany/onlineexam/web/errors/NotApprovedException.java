package com.mycompany.onlineexam.web.errors;

public class NotApprovedException extends Exception {
    public NotApprovedException(String message) {
        super(message + " is not approved yet");
    }
}
