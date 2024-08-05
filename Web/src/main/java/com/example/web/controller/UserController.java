package com.example.web.controller;

import com.example.web.model.dto.request.UserCreationDto;
import com.example.web.model.dto.request.UserUpdateDto;
import com.example.web.model.entity.User;
import com.example.web.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;
    @GetMapping
    public List<User> listUser(){
        return userService.listUser();
    }
    @PostMapping("/add")
    public User creationUser(@RequestBody @Valid UserCreationDto userCreationDto){
        return userService.creationUser(userCreationDto);
    }
    @GetMapping("/{id}")
    public Optional<User> getUser(@PathVariable Integer id){
        return userService.getUser(id);
    }
    @PutMapping("/{id}")
    public User updateUser(@PathVariable Integer id , @RequestBody UserUpdateDto userUpdateDto){
        return userService.updateUser(id , userUpdateDto);
    }
}
