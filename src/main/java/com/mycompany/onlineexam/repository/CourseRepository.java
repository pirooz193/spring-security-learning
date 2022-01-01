package com.mycompany.onlineexam.repository;

import com.mycompany.onlineexam.domain.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CourseRepository extends JpaRepository<Course, Long> {

    Course findCourseByCourseCode(String courseCode);

}
