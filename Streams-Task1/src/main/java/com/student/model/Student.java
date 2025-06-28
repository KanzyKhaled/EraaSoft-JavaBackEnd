package com.student.model;

public class Student {
	String name;
    String department;
    double grade;

    // Constructor + Getters
    public Student(String name, String department, double grade) {
        this.name = name;
        this.department = department;
        this.grade = grade;
    }

    public String getName() { return name; }
    public String getDepartment() { return department; }
    public double getGrade() { return grade; }
}


