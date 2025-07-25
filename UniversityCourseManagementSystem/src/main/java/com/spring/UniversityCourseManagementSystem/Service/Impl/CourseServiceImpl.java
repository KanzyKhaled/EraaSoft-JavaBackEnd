package com.spring.UniversityCourseManagementSystem.Service.Impl;

import com.spring.UniversityCourseManagementSystem.Service.CourseService;
import com.spring.UniversityCourseManagementSystem.model.Course;
import com.spring.UniversityCourseManagementSystem.model.Instructor;
import com.spring.UniversityCourseManagementSystem.repo.CourseRepository;
import com.spring.UniversityCourseManagementSystem.repo.InstructorRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseServiceImpl implements CourseService {
    private final CourseRepository courseRepo;
    private final InstructorRepository instructorRepo;

    public CourseServiceImpl(CourseRepository courseRepo, InstructorRepository instructorRepo) {
        this.courseRepo = courseRepo;
        this.instructorRepo = instructorRepo;
    }

    @Override
    public Course createCourse(Course course) {
        return courseRepo.save(course);
    }

    @Override
    public List<Course> getAllCourses() {
        return courseRepo.findAll();
    }

    @Override
    public Course getCourseById(Long id) {
        return courseRepo.findById(id).orElseThrow();
    }

    @Override
    public Course assignInstructorToCourse(Long courseId, Long instructorId) {
        Course course = getCourseById(courseId);
        Instructor instructor = instructorRepo.findById(instructorId).orElseThrow();
        course.setInstructor(instructor);
        return courseRepo.save(course);
    }

}
