package com.spring.lec11.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Setter
@Getter
public class Post {
    @Id
    @GeneratedValue
    private Long id;

    private String text;
    private String imagePath;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

}
