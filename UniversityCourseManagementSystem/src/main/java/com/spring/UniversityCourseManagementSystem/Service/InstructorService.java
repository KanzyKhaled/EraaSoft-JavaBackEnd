package com.spring.UniversityCourseManagementSystem.Service;

import com.spring.UniversityCourseManagementSystem.model.Instructor;

import java.util.List;

public interface InstructorService {
    Instructor createInstructor(Instructor instructor);
    List<Instructor> getAllInstructors();
    Instructor getInstructorById(Long id);
}
