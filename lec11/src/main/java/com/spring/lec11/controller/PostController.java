package com.spring.lec11.controller;


import com.spring.lec11.dto.PostDto;
import com.spring.lec11.service.PostService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.spring.lec11.model.Post;

import java.util.List;

@RestController
@RequestMapping("/posts")
public class PostController {
    private final PostService service;

    public PostController(PostService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<PostDto> create(@Valid @RequestBody PostDto dto,
                                          @RequestParam(required = false) Long userId) {
        return ResponseEntity.ok(service.createPost(dto, userId));
    }

    @GetMapping("/{id}")
    public ResponseEntity<PostDto> get(@PathVariable Long id) {
        return ResponseEntity.ok(service.getPost(id));
    }

    @GetMapping
    public ResponseEntity<List<PostDto>> getAll() {
        return ResponseEntity.ok(service.getAllPosts());
    }

    @PutMapping("/{id}")
    public ResponseEntity<PostDto> update(@PathVariable Long id, @Valid @RequestBody PostDto dto) {
        return ResponseEntity.ok(service.updatePost(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.deletePost(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/postsWithUsers")
    public ResponseEntity<List<Post>> getPostsWithUsers() {
        return ResponseEntity.ok(service.getPostsWithUsers());
    }

    @GetMapping("/postWithUsers/{id}")
    public ResponseEntity<Post> getPostWithUser(@PathVariable Long id) {
        return ResponseEntity.ok(service.getPostWithUser(id));
    }
}

