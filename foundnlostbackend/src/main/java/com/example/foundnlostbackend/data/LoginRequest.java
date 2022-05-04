package com.example.foundnlostbackend.data;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class LoginRequest {
    String email;
    String password;
}
