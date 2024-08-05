package com.example.web.service;

import com.example.web.model.dto.request.AuthenticationRequest;

public interface AuthenticationService {
    boolean authentication(AuthenticationRequest authenticationRequest);
}
