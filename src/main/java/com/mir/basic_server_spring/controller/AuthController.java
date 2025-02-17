package com.mir.basic_server_spring.controller;
import com.mir.basic_server_spring.model.APIResponse;
import com.mir.basic_server_spring.model.RegisterRequest;
import com.mir.basic_server_spring.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

@RestController
@RequestMapping("/api/auth")
public class AuthController {
    private final AuthService authService;

    @Autowired
    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    @PostMapping("/register")
    public ResponseEntity<APIResponse> register(@RequestBody RegisterRequest request) {
        authService.register(request);
        APIResponse response = new APIResponse(true, "Registration Successful", new HashMap<>());
        return ResponseEntity.status(HttpStatusCode.valueOf(201)).body(response);
    }
}
