package com.mycompany.onlineexam.service.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.mycompany.onlineexam.domain.Role;
import com.sun.istack.NotNull;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;


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
    @JsonProperty("roles")
    private List<Role> roles = new ArrayList<>();

    public StudentDTO(Long id, String username, String password, String studentCode, String phoneNumber, List<Role> roles) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.studentCode = studentCode;
        this.phoneNumber = phoneNumber;
        this.roles = roles;
    }

    public StudentDTO(Long id, String username, String password, String studentCode, String phoneNumber) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.studentCode = studentCode;
        this.phoneNumber = phoneNumber;
    }

    public StudentDTO() {
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        StudentDTO that = (StudentDTO) o;
        return id.equals(that.id) && username.equals(that.username) && password.equals(that.password) && studentCode.equals(that.studentCode) && phoneNumber.equals(that.phoneNumber) && roles.equals(that.roles);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, username, password, studentCode, phoneNumber, roles);
    }

    @Override
    public String toString() {
        return "StudentDTO{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", studentCode='" + studentCode + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", roles=" + roles +
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

    public List<Role> getRoles() {
        return roles;
    }

    public void setRoles(List<Role> roles) {
        this.roles = roles;
    }
}
