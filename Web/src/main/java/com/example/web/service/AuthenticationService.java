package com.example.web.service;

import com.example.web.exception.AppException;
import com.example.web.model.dto.request.AuthenticationRequest;
import com.example.web.model.dto.request.IntrospectRequest;
import com.example.web.model.dto.response.AuthenticationResponse;
import com.example.web.model.dto.response.IntrospectResponse;
import com.example.web.model.entity.User;
import com.nimbusds.jose.JOSEException;

import java.text.ParseException;

public interface AuthenticationService {
    AuthenticationResponse authentication(AuthenticationRequest authenticationRequest) throws JOSEException, AppException;
    String generateToken(User user) throws JOSEException;
    IntrospectResponse introspect(IntrospectRequest request) throws JOSEException, ParseException;
}
