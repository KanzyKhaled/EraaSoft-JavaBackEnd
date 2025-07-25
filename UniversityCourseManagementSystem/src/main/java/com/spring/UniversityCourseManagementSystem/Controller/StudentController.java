package com.spring.UniversityCourseManagementSystem.Controller;
import com.spring.UniversityCourseManagementSystem.Service.StudentService;
import com.spring.UniversityCourseManagementSystem.model.Student;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/students")
public class StudentController {

    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @PostMapping
    public ResponseEntity<Student> createStudent(@RequestBody Student student) {
        Student created = studentService.createStudent(student);
        return ResponseEntity.status(HttpStatus.CREATED).body(created);
    }

    @GetMapping
    public ResponseEntity<List<Student>> getAllStudents() {
        return ResponseEntity.ok(studentService.getAllStudents());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Student> getStudentById(@PathVariable Long id) {
        return ResponseEntity.ok(studentService.getStudentById(id));
    }

    @PutMapping("/{studentId}/courses/{courseId}")
    public ResponseEntity<Student> registerStudentToCourse(@PathVariable Long studentId, @PathVariable Long courseId) {
        Student updated = studentService.registerStudentToCourse(studentId, courseId);
        return ResponseEntity.ok(updated);
    }
}