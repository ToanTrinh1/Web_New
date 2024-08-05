package com.example.web.service;

import com.example.web.exception.AppException;
import com.example.web.model.dto.request.AuthenticationRequest;
import com.example.web.model.dto.response.AuthenticationResponse;
import com.nimbusds.jose.JOSEException;

public interface AuthenticationService {
    AuthenticationResponse authentication(AuthenticationRequest authenticationRequest) throws JOSEException, AppException;
    String generateToken(String username) throws JOSEException;
}
