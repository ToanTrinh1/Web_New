package com.example.web.controller;

import com.example.web.model.dto.UserCreationDto;
import com.example.web.model.entity.User;
import com.example.web.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
    public User creationUser(@RequestBody UserCreationDto userCreationDto){
        return userService.creationUser(userCreationDto);
    }
    @GetMapping("/{id}")
    public User getUser(@PathVariable Integer id){
        return userService.getUser(id);
    }
}
