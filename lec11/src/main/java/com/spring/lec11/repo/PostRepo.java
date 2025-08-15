package com.spring.lec11.repo;

import com.spring.lec11.model.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepo extends JpaRepository<Post, Long> {

}

