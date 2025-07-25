package com.spring.UniversityCourseManagementSystem.repo;

import com.spring.UniversityCourseManagementSystem.model.Course;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseRepository extends JpaRepository<Course, Long>
{

}
