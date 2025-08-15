package com.spring.lec11.repo;

import com.spring.lec11.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<User, Long> {
}
