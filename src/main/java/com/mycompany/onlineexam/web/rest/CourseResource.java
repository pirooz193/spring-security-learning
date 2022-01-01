package com.mycompany.onlineexam.web.rest;

import com.mycompany.onlineexam.domain.Course;
import com.mycompany.onlineexam.domain.constants.Constants;
import com.mycompany.onlineexam.service.CourseService;
import com.mycompany.onlineexam.service.dto.CourseDTO;
import com.mycompany.onlineexam.web.errors.FullCapacityException;
import com.mycompany.onlineexam.web.errors.StudentExistenceException;
import com.mycompany.onlineexam.web.mdel.ApiUtil;
import com.mycompany.onlineexam.web.mdel.ServiceResult;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.HttpClientErrorException;
import org.zalando.problem.Status;

import javax.swing.plaf.IconUIResource;
import java.net.URI;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/course")
public class CourseResource {

    private final Logger logger = LogManager.getLogger(CourseResource.class);

    private final CourseService courseService;

    public CourseResource(CourseService courseService) {
        this.courseService = courseService;
    }

    @PostMapping("/create")
    public ResponseEntity<Course> createCourse(@RequestBody CourseDTO courseDTO) {
        logger.info("Request to create a new Course:{} ", courseDTO);
        Course course = courseService.createCourse(courseDTO);
        return ResponseEntity.created(URI.create("/created")).body(course);
    }

    @GetMapping("/get-all")
    public ResponseEntity<List<Course>> getAllCourses() {
        logger.info("Request to get all courses");
            List<Course> courses = courseService.getAllCourses();
        return ResponseEntity.ok(courses);
    }

    @GetMapping("/get-course")
    public ResponseEntity<Course> getCourse(@RequestParam String courseCode) {
        logger.info("Request to get Course vy course-code :{}", courseCode);
            Course course = courseService.getCourseByCourseCode(courseCode);
        return ResponseEntity.ok(course);
    }

    @PutMapping("/add-student")
    public ResponseEntity<Integer> addStudentToCourse(@RequestParam String courseCode, @RequestParam String studentCode) throws FullCapacityException, StudentExistenceException {
        logger.info("Request to add ann student with studentCode:{} to  course with courseCode:{}", studentCode, courseCode);
            Integer courseCapacity = courseService.addStudentToCourse(studentCode, courseCode);
        return ResponseEntity.ok(courseCapacity);
    }

    @PutMapping("/add-master")
    public ResponseEntity<Course> addMasterToCourse(@RequestParam String masterCode, @RequestParam String courseCode) {
        logger.info("Request to add ann master with masterCode:{} to  course with courseCode:{}", masterCode, courseCode);
            Course course = courseService.addMasterToCourse(masterCode, courseCode);
        return ResponseEntity.ok(course);
    }

}
