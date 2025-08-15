package com.spring.lec11.service.impl;

import com.spring.lec11.dto.PostDto;
import com.spring.lec11.mapper.PostMapper;
import com.spring.lec11.model.Post;
import com.spring.lec11.model.User;
import com.spring.lec11.repo.PostRepo;
import com.spring.lec11.repo.UserRepo;
import com.spring.lec11.service.PostService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostServiceImpl implements PostService {
    private final PostRepo postRepo;
    private final PostMapper mapper;
    private final UserRepo userRepo;

    public PostServiceImpl(PostRepo postRepo, PostMapper mapper, UserRepo userRepo) {
        this.postRepo = postRepo;
        this.mapper = mapper;
        this.userRepo = userRepo;
    }

    @Override
    public PostDto createPost(PostDto dto, Long userId) {
        Post post = mapper.toEntity(dto);
        if (userId != null) {
            User user = userRepo.findById(userId).orElseThrow();
            post.setUser(user);
        }
        return mapper.toDto(postRepo.save(post));
    }

    @Override
    public List<PostDto> getAllPosts() {
        return postRepo.findAll().stream().map(mapper::toDto).toList();
    }

    @Override
    public PostDto getPost(Long id) {
        return mapper.toDto(postRepo.findById(id).orElseThrow());
    }

    @Override
    public void deletePost(Long id) {
        postRepo.deleteById(id);
    }

    @Override
    public PostDto updatePost(Long id, PostDto dto) {
        Post post = postRepo.findById(id).orElseThrow();
        post.setText(dto.getText());
        post.setImagePath(dto.getImagePath());
        return mapper.toDto(postRepo.save(post));
    }

    @Override
    public List<Post> getPostsWithUsers() {
        return postRepo.findAll();
    }

    @Override
    public Post getPostWithUser(Long id) {
        return postRepo.findById(id).orElseThrow();
    }
}

