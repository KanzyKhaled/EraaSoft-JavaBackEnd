package com.spring.lec11.service.impl;

import com.spring.lec11.dto.UserDto;
import com.spring.lec11.mapper.UserMapper;
import com.spring.lec11.model.User;
import com.spring.lec11.repo.UserRepo;
import com.spring.lec11.service.UserService;
import org.springframework.stereotype.Service;
import com.spring.lec11.model.Post;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepo userRepo;
    private final UserMapper mapper;

    public UserServiceImpl(UserRepo userRepo, UserMapper mapper) {
        this.userRepo = userRepo;
        this.mapper = mapper;
    }

    @Override
    public UserDto createUser(UserDto dto) {
        User user = mapper.toEntity(dto);
        return mapper.toDto(userRepo.save(user));
    }

    @Override
    public List<UserDto> getAllUsers() {
        return userRepo.findAll().stream().map(mapper::toDto).toList();
    }

    @Override
    public UserDto getUser(Long id) {
        return mapper.toDto(userRepo.findById(id).orElseThrow());
    }

    @Override
    public void deleteUser(Long id) {
        userRepo.deleteById(id);
    }

    @Override
    public UserDto updateUser(Long id, UserDto dto) {
        User user = userRepo.findById(id).orElseThrow();
        user.setName(dto.getName());
        user.setAge(dto.getAge());
        user.setPassword(dto.getPassword());
        return mapper.toDto(userRepo.save(user));
    }

    @Override
    public List<Post> getUserPosts(Long userId) {
        return userRepo.findById(userId).orElseThrow().getPosts();
    }

    @Override
    public List<User> getUsersWithPosts() {
        return userRepo.findAll();
    }

    @Override
    public User getUserWithPosts(Long id) {
        return userRepo.findById(id).orElseThrow();
    }
}


