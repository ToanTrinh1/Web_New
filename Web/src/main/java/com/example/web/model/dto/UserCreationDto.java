package com.example.web.model.dto;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserCreationDto {
    private String fullName;
    private String email;
    private String phone;
    private String address;
    private String username;
    private String password;
    private String role;
}
