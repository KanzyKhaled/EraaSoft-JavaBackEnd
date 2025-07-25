package com.spring.UniversityCourseManagementSystem.model;


import jakarta.persistence.*;
import org.springframework.data.annotation.Id;

import java.util.HashSet;
import java.util.Set;

@Entity
public class Student {
    @Id @GeneratedValue
    private Long id;
    private String name;
    private String email;

    @ManyToMany
    @JoinTable(
            name = "student_course",
            joinColumns = @JoinColumn(name = "studnet_id"),
            inverseJoinColumns = @JoinColumn(name = "course_id")

    )
    private Set<Course> courses = new HashSet<>();
    public Set<Course> getCourses() {
        return courses;
    }

    public void setCourses(Set<Course> courses) {
        this.courses = courses;
    }


}


