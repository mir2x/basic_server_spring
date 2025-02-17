package com.mir.basic_server_spring.service;

import com.mir.basic_server_spring.entity.Auth;
import com.mir.basic_server_spring.model.RegisterRequest;
import com.mir.basic_server_spring.repository.AuthRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthService {
    private final AuthRepository authRepository;
    private final BCryptPasswordEncoder passwordEncoder;

    @Autowired
    public AuthService(AuthRepository authRepository, BCryptPasswordEncoder passwordEncoder) {
        this.authRepository = authRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public void register(RegisterRequest request) {

        Auth auth = Auth.builder().email(request.getEmail()).password(passwordEncoder.encode(request.getPassword())).isVerified(false).build();
        authRepository.save(auth);
    }
}
