package com.spring.UniversityCourseManagementSystem.Service;

import com.spring.UniversityCourseManagementSystem.model.Student;

import java.util.List;

public interface StudentService {
    Student createStudent(Student student);
    List<Student> getAllStudents();
    Student getStudentById(Long id);
    Student registerStudentToCourse(Long studentId, Long courseId);
}
