package com.mir.basic_server_spring.model;

import lombok.Data;

@Data
public class RegisterRequest {
    private String email;
    private String password;
}
