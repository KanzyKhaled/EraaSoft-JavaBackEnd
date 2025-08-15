package com.spring.lec11.controller;

import com.spring.lec11.dto.UserDto;
import com.spring.lec11.service.UserService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.spring.lec11.model.Post;
import com.spring.lec11.model.User;
import java.util.List;
@RestController
@RequestMapping("/users")
public class UserController {
    private final UserService service;

    public UserController(UserService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<UserDto> create(@Valid @RequestBody UserDto dto) {
        return ResponseEntity.ok(service.createUser(dto));
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserDto> get(@PathVariable Long id) {
        return ResponseEntity.ok(service.getUser(id));
    }

    @GetMapping
    public ResponseEntity<List<UserDto>> getAll() {
        return ResponseEntity.ok(service.getAllUsers());
    }

    @PutMapping("/{id}")
    public ResponseEntity<UserDto> update(@PathVariable Long id, @Valid @RequestBody UserDto dto) {
        return ResponseEntity.ok(service.updateUser(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.deleteUser(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}/posts")
    public ResponseEntity<List<Post>> getUserPosts(@PathVariable Long id) {
        return ResponseEntity.ok(service.getUserPosts(id));
    }

    @GetMapping("/usersWithPost")
    public ResponseEntity<List<User>> getUsersWithPosts() {
        return ResponseEntity.ok(service.getUsersWithPosts());
    }

    @GetMapping("/userWithPost/{id}")
    public ResponseEntity<User> getUserWithPosts(@PathVariable Long id) {
        return ResponseEntity.ok(service.getUserWithPosts(id));
    }
}

