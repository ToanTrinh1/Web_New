package com.example.web.mapper;

import com.example.web.model.dto.request.UserCreationDto;

import com.example.web.model.dto.request.UserUpdateDto;
import com.example.web.model.dto.response.UserResponse;
import com.example.web.model.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface UserMapper {
    User toUser(UserCreationDto userCreationDto);

    void toUser(@MappingTarget User user , UserUpdateDto userUpdateDto);
}
