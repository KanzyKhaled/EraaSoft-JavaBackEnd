package com.spring.UniversityCourseManagementSystem.Controller;
import com.spring.UniversityCourseManagementSystem.Service.CourseService;
import com.spring.UniversityCourseManagementSystem.model.Course;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/courses")
public class CourseController {

    private final CourseService courseService;

    public CourseController(CourseService courseService) {
        this.courseService = courseService;
    }

    @PostMapping
    public ResponseEntity<Course> createCourse(@RequestBody Course course) {
        Course created = courseService.createCourse(course);
        return ResponseEntity.status(HttpStatus.CREATED).body(created);
    }

    @GetMapping
    public ResponseEntity<List<Course>> getAllCourses() {
        return ResponseEntity.ok(courseService.getAllCourses());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Course> getCourseById(@PathVariable Long id) {
        return ResponseEntity.ok(courseService.getCourseById(id));
    }

    @PutMapping("/{courseId}/instructor/{instructorId}")
    public ResponseEntity<Course> assignInstructor(@PathVariable Long courseId, @PathVariable Long instructorId) {
        Course updated = courseService.assignInstructorToCourse(courseId, instructorId);
        return ResponseEntity.ok(updated);
    }
}
