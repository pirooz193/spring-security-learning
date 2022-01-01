package com.mycompany.onlineexam.repository;

import com.mycompany.onlineexam.domain.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {
    Student getStudentByUsernameAndPassword(String username, String password);

    void deleteStudentByStudentCode(String studentCode);

    Student getStudentByStudentCode(String studnetCode);

    Student findStudentByUsername(String username);

}
