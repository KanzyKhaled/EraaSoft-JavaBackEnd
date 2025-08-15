package com.spring.lec11.service;

import com.spring.lec11.dto.PostDto;
import com.spring.lec11.model.Post;

import java.util.List;

public interface PostService {
    PostDto createPost(PostDto dto, Long userId);
    List<PostDto> getAllPosts();
    PostDto getPost(Long id);
    void deletePost(Long id);
    PostDto updatePost(Long id, PostDto dto);
    List<Post> getPostsWithUsers();
    Post getPostWithUser(Long id);
}
