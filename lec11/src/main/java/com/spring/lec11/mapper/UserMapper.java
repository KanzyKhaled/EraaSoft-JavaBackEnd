package com.spring.lec11.mapper;

import com.spring.lec11.dto.UserDto;
import com.spring.lec11.model.User;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper {
    User toEntity(UserDto dto);
    UserDto toDto(User entity);
}
