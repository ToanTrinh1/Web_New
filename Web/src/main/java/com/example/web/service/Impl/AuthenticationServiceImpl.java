package com.example.web.service.Impl;

import com.example.web.exception.AppException;
import com.example.web.exception.ErrorCode;
import com.example.web.model.dto.request.AuthenticationRequest;
import com.example.web.model.dto.response.AuthenticationResponse;
import com.example.web.repository.UserRepository;
import com.example.web.service.AuthenticationService;
import com.nimbusds.jose.*;
import com.nimbusds.jose.crypto.MACSigner;
import com.nimbusds.jwt.JWTClaimsSet;
import lombok.experimental.NonFinal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContextException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.Date;

@Service
public class AuthenticationServiceImpl implements AuthenticationService {
    @Autowired
    UserRepository userRepository;
    @NonFinal
    protected static final String SIGN_KEY = "vPtohaADpCtWBSXJcM09Rx633hhW/wV+BzMEgcCCc20D77hpFre7iUaR5XWH4ug8";

    @Override
    public AuthenticationResponse authentication(AuthenticationRequest request) throws AppException, JOSEException {
        var user = userRepository.findByUsername(request.getUsername()).
                orElseThrow(() -> new ApplicationContextException("Không tìm thấy tài khoản"));
        PasswordEncoder passwordEncoder = new BCryptPasswordEncoder(10);
            boolean authenticated = passwordEncoder.matches(request.getPassword(), user.getPassword());
            if(!authenticated)
                throw new ApplicationContextException("Sai mật khẩu");
            var token = generateToken(request.getUsername());

            return AuthenticationResponse.builder()
                    .token(token)
                    .authenticated(true)
                    .build();
        }

    @Override
    public String generateToken(String username) throws JOSEException {
        JWSHeader header = new JWSHeader(JWSAlgorithm.HS256);
        JWTClaimsSet jwtClaimsSet = new JWTClaimsSet.Builder()
                .subject(username)
                .issuer("toan") // token được issuer từ ai
                .issueTime(new Date())
                .expirationTime(new Date(
                        Instant.now().plus(1, ChronoUnit.HOURS).toEpochMilli()
                ))
                .build();
        Payload payload = new Payload(jwtClaimsSet.toJSONObject());
        JWSObject jwsObject = new JWSObject(header, payload);
        try {
            jwsObject.sign(new MACSigner(SIGN_KEY.getBytes()));
            return jwsObject.serialize();
        }catch (JOSEException e){
            throw new RuntimeException(e);
        }
    }

}
