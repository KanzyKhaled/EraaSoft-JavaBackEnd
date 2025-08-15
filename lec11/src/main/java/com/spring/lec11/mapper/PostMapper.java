package com.spring.lec11.mapper;

import com.spring.lec11.dto.PostDto;
import com.spring.lec11.model.Post;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PostMapper {
    Post toEntity(PostDto dto);
    PostDto toDto(Post entity);
}
