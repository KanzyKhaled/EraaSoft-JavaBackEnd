package com.spring.app.model;


import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
@Entity
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private int age;
    private double salary;


    @OneToMany(mappedBy = "employee", cascade = CascadeType.ALL)
    private Set<Email> emails = new HashSet<>();


}
