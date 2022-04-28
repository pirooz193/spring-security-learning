package com.mycompany.onlineexam.service;

import com.mycompany.onlineexam.domain.Course;
import com.mycompany.onlineexam.service.dto.CourseDTO;
import com.mycompany.onlineexam.web.errors.FullCapacityException;
import com.mycompany.onlineexam.web.errors.StudentExistenceException;

import java.util.List;

public interface CourseService {
    Course createCourse(CourseDTO courseDTO);

    Integer addStudentToCourse(String studentCode, String courseCode) throws FullCapacityException, StudentExistenceException;

    Course addMasterToCourse(String masterCode, String courseCode);

    Course getCourseByCourseCode(String courseCode);

    List<Course> getAllCourses();

    List<Course> getRequiredMasterCourses(String masterCode);
}
