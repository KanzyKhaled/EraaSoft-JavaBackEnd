package com.spring.app.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;




@Entity
@Getter
@Setter
public class Email {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String content;

    @ManyToOne
    @JoinColumn(name = "employee_id")
    private Employee employee;
}