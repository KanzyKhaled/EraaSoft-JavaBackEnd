package com.spring.dao;


import com.spring.model.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface TeacherDao extends JpaRepository<Teacher, Long> {
    @Query("SELECT t FROM Teacher t LEFT JOIN FETCH t.students WHERE t.id = :id")
    Teacher findByIdWithStudents(@Param("id") Long id);

    @Query("SELECT DISTINCT t FROM Teacher t LEFT JOIN FETCH t.students")
    List<Teacher> findAllWithStudents();


}
