package com.mycompany.onlineexam.domain;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "student_table")
public class Student extends  User{

    @Column(name = "student_code", nullable = false, unique = true)
    private String studentCode;
    @Column(name = "phone_number" , nullable = false , unique = true)
    private String phoneNumber ;

    public Student(String username, String password, String studentCode, String phoneNumber) {
        super.setUsername(username);
        super.setPassword(password);
        this.studentCode = studentCode;
        this.phoneNumber = phoneNumber;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return studentCode.equals(student.studentCode) && phoneNumber.equals(student.phoneNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(studentCode, phoneNumber);
    }

    @Override
    public String toString() {
        return "Student{" +
                "studentCode='" + studentCode + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                '}';
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
