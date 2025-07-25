package com.spring.UniversityCourseManagementSystem.repo;

import com.spring.UniversityCourseManagementSystem.model.Instructor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InstructorRepository extends JpaRepository<Instructor, Long> {
}
