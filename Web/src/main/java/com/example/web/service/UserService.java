package com.example.web.service;

import com.example.web.model.dto.request.UserCreationDto;
import com.example.web.model.dto.request.UserUpdateDto;
import com.example.web.model.dto.response.UserResponse;
import com.example.web.model.entity.User;

import java.util.List;
import java.util.Optional;

public interface UserService {
    User creationUser(UserCreationDto userCreationDto);
    Optional<User> getUser(Integer id);
    User updateUser(Integer id , UserUpdateDto userUpdateDto);
    List<User> listUser();
}
