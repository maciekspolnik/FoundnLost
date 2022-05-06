package com.example.foundnlost.data.network.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class LoginRequest {
    String email;
    String password;
}

