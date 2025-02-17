package com.mir.basic_server_spring.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Map;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class APIResponse {
    private boolean isSuccess;
    private String message;
    private Map<String, Object> data;
}
