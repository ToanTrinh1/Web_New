package com.example.web.controller;

import ch.qos.logback.core.spi.ErrorCodes;
import com.example.web.exception.AppException;
import com.example.web.model.dto.request.AuthenticationRequest;
import com.example.web.model.dto.response.AuthenticationResponse;
import com.example.web.service.AuthenticationService;
import com.nimbusds.jose.JOSEException;
import io.swagger.v3.oas.models.responses.ApiResponse;
import org.apache.log4j.spi.ErrorCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.ErrorResponse;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthenticationController {
    @Autowired
    private AuthenticationService authenticationService;
    @PostMapping("/login")
    public ResponseEntity<AuthenticationResponse> login(@RequestBody AuthenticationRequest
            request) throws AppException, JOSEException {
        AuthenticationResponse response = authenticationService.authentication(request);
        return ResponseEntity.ok(response);
    }
}
