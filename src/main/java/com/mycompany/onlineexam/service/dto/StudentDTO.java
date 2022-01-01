package com.mycompany.onlineexam.service.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.sun.istack.NotNull;

public class StudentDTO {
    @JsonProperty("id")
    private Long id;
    @JsonProperty("username")
    @NotNull
    private String username;
    @JsonProperty("password")
    private String password;
    @JsonProperty("student_code")
    private String studentCode;
    @JsonProperty("phone_number")
    private String phoneNumber;


    @Override
    public String toString() {
        return "StudentDTO{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", studentCode='" + studentCode + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                '}';
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getStudentCode() {
        return studentCode;
    }

    public void setStudentCode(String studentCode) {
        this.studentCode = studentCode;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}
