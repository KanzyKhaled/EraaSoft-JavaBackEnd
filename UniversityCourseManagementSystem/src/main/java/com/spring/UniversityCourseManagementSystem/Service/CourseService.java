package com.spring.UniversityCourseManagementSystem.Service;

import com.spring.UniversityCourseManagementSystem.model.Course;

import java.util.List;

public interface CourseService {
    Course createCourse(Course course);
    List<Course> getAllCourses();
    Course getCourseById(Long id);
    Course assignInstructorToCourse(Long courseId, Long instructorId);
}
