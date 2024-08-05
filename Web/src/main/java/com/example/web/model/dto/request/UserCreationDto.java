package com.example.web.model.dto.request;


import jakarta.validation.constraints.Size;
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
    @Size(min = 6 , message = "Password must be at least 6 character ")
    private String password;
    private String role;
}
