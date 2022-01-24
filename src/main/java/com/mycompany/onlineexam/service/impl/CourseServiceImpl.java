package com.mycompany.onlineexam.service.impl;

import com.mycompany.onlineexam.domain.Course;
import com.mycompany.onlineexam.domain.Master;
import com.mycompany.onlineexam.domain.Student;
import com.mycompany.onlineexam.domain.constants.Constants;
import com.mycompany.onlineexam.repository.CourseRepository;
import com.mycompany.onlineexam.service.CourseService;
import com.mycompany.onlineexam.service.MasterService;
import com.mycompany.onlineexam.service.StudentService;
import com.mycompany.onlineexam.service.dto.CourseDTO;
import com.mycompany.onlineexam.service.mapper.CourseMapper;
import com.mycompany.onlineexam.web.errors.FullCapacityException;
import com.mycompany.onlineexam.web.errors.StudentExistenceException;
import com.mycompany.onlineexam.web.model.ApiUtil;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseServiceImpl implements CourseService {

    private final Logger logger = LogManager.getLogger(CourseServiceImpl.class);
    private final CourseRepository courseRepository;
    private final StudentService studentService;
    private final MasterService masterService;
    private final CourseMapper courseMapper;

    public CourseServiceImpl(CourseRepository courseRepository, StudentService studentService, MasterService masterService, CourseMapper courseMapper) {
        this.courseRepository = courseRepository;
        this.studentService = studentService;
        this.masterService = masterService;
        this.courseMapper = courseMapper;
    }

    /**
     * Save a new Course
     *
     * @param courseDTO
     * @return
     */
    @Override
    public Course createCourse(CourseDTO courseDTO) {
        logger.debug("Request to create a new Course:{} ", courseDTO);
        Course course = courseMapper.toEntity(courseDTO);
        course.setCourseCode(ApiUtil.generateRandomCode(Constants.COURSE, 5));
        return courseRepository.save(course);
    }

    /**
     * Get Course and Student by course-code and student-code
     * Add student to course and calculate course capacity nex adding
     *
     * @param studentCode
     * @param courseCode
     * @return
     */
    @Override
    public Integer addStudentToCourse(String studentCode, String courseCode) throws FullCapacityException, StudentExistenceException {
        logger.debug("Request to add ann student with studentCode:{} to  course with courseCode:{}", studentCode, courseCode);
        Course course = courseRepository.findCourseByCourseCode(courseCode);
        if (course.getStudents().size() >= course.getCourseCapacity())
            throw new FullCapacityException(course.getCourseTitle());
        if (course.getStudents().stream().anyMatch(student -> student.getStudentCode().equals(studentCode)))
            throw new StudentExistenceException(studentCode);
        Student student = studentService.getStudentByStudentCode(studentCode);
        course.getStudents().add(student);
        courseRepository.save(course);
        return course.getCourseCapacity() - course.getStudents().size();
    }

    /**
     * Add a master to course
     * get master and course by  master-code and course-code
     *
     * @param masterCode
     * @param courseCode
     * @return
     */
    @Override
    public Course addMasterToCourse(String masterCode, String courseCode) {
        logger.debug("Request to add ann master with masterCode:{} to  course with courseCode:{}", masterCode, courseCode);
        Course course = courseRepository.findCourseByCourseCode(courseCode);
        Master master = masterService.getMasterByMasterCode(masterCode);
        course.setMaster(master);
        courseRepository.save(course);
        return course;
    }

    /**
     * Fetch  course by  course-code
     *
     * @param courseCode
     * @return
     */
    @Override
    public Course getCourseByCourseCode(String courseCode) {
        logger.debug("Request to get Course vy course-code :{} in service layer", courseCode);
        return courseRepository.findCourseByCourseCode(courseCode);
    }

    /**
     * Fetch all courses
     *
     * @return
     */
    @Override
    public List<Course> getAllCourses() {
        logger.info("Request to get all courses");
        return courseRepository.findAll();
    }

}
