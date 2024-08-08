package com.example.web.service.Impl;

import com.example.web.enums.Role;
import com.example.web.mapper.UserMapper;
import com.example.web.model.dto.request.UserCreationDto;
import com.example.web.model.dto.request.UserUpdateDto;
import com.example.web.model.entity.User;
import com.example.web.repository.UserRepository;
import com.example.web.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContextException;
import org.springframework.security.access.prepost.PostAuthorize;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Override
    public User creationUser(UserCreationDto userCreationDto) {
        if (userRepository.existsByUsername(userCreationDto.getUsername())) {
            throw new ApplicationContextException("Tài khoản đã tồn tại");
        }
        User user = userMapper.toUser(userCreationDto);
        user.setPassword(passwordEncoder.encode(userCreationDto.getPassword()));
        HashSet<Role> roles = new HashSet<>();
        roles.add(Role.USER);
        user.setRoles(roles);
        return userRepository.save(user);
    }

    public Optional<User> getUser() {
        return getUser(null);
    }

    @Override
    @PostAuthorize("returnObject.get().username == authentication.name")
    public Optional<User> getUser(Integer id) {
        return Optional.ofNullable(userRepository.findByid(id)).orElseThrow(() -> new RuntimeException("ko tim thay"));
    }

    @Override
    public User updateUser(Integer id, UserUpdateDto userUpdateDto) {
        User user = userRepository.findById(id).orElseThrow(() -> new RuntimeException("ko tim thay"));
        userMapper.toUser(user, userUpdateDto);
        return userRepository.save(user);
    }

    @Override
    @PreAuthorize("hasRole('ADMIN')")
    public List<User> listUser() {
        return userRepository.findAll();
    }

    @Override
    public User getMyInfor() {
        var context = SecurityContextHolder.getContext();
        String name = context.getAuthentication().getName();
        return userRepository.findByUsername(name)
                .orElseThrow(() -> new RuntimeException("Không có thông tin"));
    }
}
