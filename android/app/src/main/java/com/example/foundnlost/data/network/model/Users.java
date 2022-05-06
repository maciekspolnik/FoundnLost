package com.example.foundnlost.data.network.model;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Users {
    private Long userId;
    private String name;
    private String surname;
    private String email;
    private String password;
    private String phone;
    private Date dateOfBirth;

}
