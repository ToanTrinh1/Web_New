package com.example.web.service;

import com.example.web.model.dto.UserCreationDto;
import com.example.web.model.entity.User;

import java.util.List;

public interface UserService {
    User creationUser(UserCreationDto userCreationDto);
    User getUser(Integer id);

    List<User> listUser();
}
