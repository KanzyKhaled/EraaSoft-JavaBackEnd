package com.spring.UniversityCourseManagementSystem.Service.Impl;

import com.spring.UniversityCourseManagementSystem.Service.StudentService;
import com.spring.UniversityCourseManagementSystem.model.Course;
import com.spring.UniversityCourseManagementSystem.model.Student;
import com.spring.UniversityCourseManagementSystem.repo.CourseRepository;
import com.spring.UniversityCourseManagementSystem.repo.StudentRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {

    private final StudentRepository studentRepo;
    private final CourseRepository courseRepo;

    public StudentServiceImpl(StudentRepository studentRepo, CourseRepository courseRepo) {
        this.studentRepo = studentRepo;
        this.courseRepo = courseRepo;
    }

    @Override
    public Student createStudent(Student student) {
        return studentRepo.save(student);
    }

    @Override
    public List<Student> getAllStudents() {
        return studentRepo.findAll();
    }

    @Override
    public Student getStudentById(Long id) {
        return studentRepo.findById(id).orElseThrow();
    }

    @Override
    public Student registerStudentToCourse(Long studentId, Long courseId) {
        Student student = getStudentById(studentId);
        Course course = courseRepo.findById(courseId).orElseThrow();
        student.getCourses().add(course);
        return studentRepo.save(student);
    }
}
