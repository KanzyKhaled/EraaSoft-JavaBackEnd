package com.spring.service.impl;


import com.spring.dao.TeacherDao;
import com.spring.dto.TeacherDto;
import com.spring.mapper.TeacherMapper;
import com.spring.model.Teacher;
import com.spring.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TeacherServiceImpl implements TeacherService {


    @Autowired
    private TeacherDao teacherDao;

    @Override
    public List<TeacherDto> getAllTeacher() {
        return TeacherMapper.teacherMapper.toDtoList(teacherDao.findAll());
    }

    @Override
    public TeacherDto getTeacherWithStudentsById(Long id) {
        Teacher teacher = teacherDao.findByIdWithStudents(id);
        if (teacher == null) {
            throw new RuntimeException("Teacher not found with id: " + id);
        }
        return TeacherMapper.teacherMapper.toDto(teacher);
    }

    @Override
    public List<TeacherDto> getAllTeachersWithStudents() {
        List<Teacher> teachers = teacherDao.findAllWithStudents();
        return TeacherMapper.teacherMapper.toDtoList(teachers);
    }



}
