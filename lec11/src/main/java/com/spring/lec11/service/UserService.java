package com.spring.lec11.service;


import com.spring.lec11.dto.UserDto;
import com.spring.lec11.model.Post;
import com.spring.lec11.model.User;

import java.util.List;

public interface UserService {
    UserDto createUser(UserDto dto);
    List<UserDto> getAllUsers();
    UserDto getUser(Long id);
    void deleteUser(Long id);
    UserDto updateUser(Long id, UserDto dto);
    List<Post> getUserPosts(Long userId);
    List<User> getUsersWithPosts();
    User getUserWithPosts(Long id);
}

