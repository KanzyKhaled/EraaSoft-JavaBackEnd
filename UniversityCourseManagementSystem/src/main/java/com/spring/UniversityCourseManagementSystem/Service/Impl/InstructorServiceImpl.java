package com.spring.UniversityCourseManagementSystem.Service.Impl;

import com.spring.UniversityCourseManagementSystem.Service.InstructorService;
import com.spring.UniversityCourseManagementSystem.model.Instructor;
import com.spring.UniversityCourseManagementSystem.repo.InstructorRepository;

import java.util.List;

public class InstructorServiceImpl implements InstructorService {
    private final InstructorRepository instructorRepo;

    public InstructorServiceImpl(InstructorRepository instructorRepo) {
        this.instructorRepo = instructorRepo;
    }

    @Override
    public Instructor createInstructor(Instructor instructor) {
        return instructorRepo.save(instructor);
    }

    @Override
    public List<Instructor> getAllInstructors() {
        return instructorRepo.findAll();
    }

    @Override
    public Instructor getInstructorById(Long id) {
        return instructorRepo.findById(id).orElseThrow();
    }
}
