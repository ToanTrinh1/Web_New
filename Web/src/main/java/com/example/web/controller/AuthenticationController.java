package com.example.web.controller;

import com.example.web.exception.AppException;
import com.example.web.model.dto.request.AuthenticationRequest;
import com.example.web.model.dto.request.IntrospectRequest;
import com.example.web.model.dto.response.AuthenticationResponse;
import com.example.web.model.dto.response.IntrospectResponse;
import com.example.web.service.AuthenticationService;
import com.nimbusds.jose.JOSEException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.text.ParseException;

@RestController
@RequestMapping("/auth")
public class AuthenticationController {
    @Autowired
    private AuthenticationService authenticationService;
    @PostMapping("/token")
    public ResponseEntity<AuthenticationResponse> login(@RequestBody AuthenticationRequest
            request) throws AppException, JOSEException {
        AuthenticationResponse response = authenticationService.authentication(request);
        return ResponseEntity.ok(response);
    }
    @PostMapping("/introspect")
    public ResponseEntity<IntrospectResponse> authenticate(@RequestBody IntrospectRequest request) throws AppException, JOSEException, ParseException {
        IntrospectResponse response = authenticationService.introspect(request);
        return ResponseEntity.ok(response);
    }
}
