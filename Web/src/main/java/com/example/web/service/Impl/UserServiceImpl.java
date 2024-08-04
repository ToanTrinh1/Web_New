package com.example.web.service.Impl;

import com.example.web.model.dto.UserCreationDto;
import com.example.web.model.entity.User;
import com.example.web.repository.UserRepository;
import com.example.web.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;
    @Override
    public User creationUser(UserCreationDto userCreationDto) {
        User user = new User();

        user.setFullName(userCreationDto.getFullName());
        user.setEmail(userCreationDto.getEmail());
        user.setPhone(userCreationDto.getPhone());
        user.setAddress(userCreationDto.getAddress());
        user.setUsername(userCreationDto.getUsername());
        user.setPassword(userCreationDto.getPassword());
        user.setRole(userCreationDto.getRole());
        return userRepository.save(user);
    }

    @Override
    public User getUser(Integer id) {
        return userRepository.findByid(id).orElseThrow(() -> new AppException(ErrorCode.USER_NOT_EXISTED));
    }

    @Override
    public List<User> listUser() {
        return userRepository.findAll();
    }
}
