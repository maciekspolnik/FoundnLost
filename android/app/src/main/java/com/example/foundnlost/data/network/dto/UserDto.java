package com.example.foundnlost.data.network.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class UserDto {
    private String name;
    private String surname;
    private String email;
    private String password;
    private String phone;
    private String dateOfBirth;

}
