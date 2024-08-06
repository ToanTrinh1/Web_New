package com.example.web.mapper.mapperimpl;

import com.example.web.mapper.UserMapper;
import com.example.web.model.dto.request.UserCreationDto;
import com.example.web.model.dto.request.UserUpdateDto;
import com.example.web.model.entity.User;
import org.mapstruct.MappingTarget;
import org.springframework.stereotype.Component;

@Component
public class UserMapperimpl implements UserMapper {
    @Override
    public User toUser(UserCreationDto userCreationDto) {
            User user = new User();
            user.setFullName(userCreationDto.getFullName());
            user.setEmail(userCreationDto.getEmail());
            user.setPhone(userCreationDto.getPhone());
            user.setAddress(userCreationDto.getAddress());
            user.setUsername(userCreationDto.getUsername());
            user.setPassword(userCreationDto.getPassword());
            return user;

    }

    @Override
    public void toUser(@MappingTarget User user, UserUpdateDto userUpdateDto) {
            user.setFullName(userUpdateDto.getFullName());
            user.setEmail(userUpdateDto.getEmail());
            user.setPhone(userUpdateDto.getPhone());
            user.setPassword(userUpdateDto.getPassword());
    }

}

