package com.example.foundnlostbackend.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class LoginRequest {
    String email;
    String password;
}
