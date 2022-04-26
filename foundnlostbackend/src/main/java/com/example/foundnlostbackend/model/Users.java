package com.example.foundnlostbackend.model;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDate;

@Entity
@Getter
@Setter
@RequiredArgsConstructor
public class Users {

    public Users(String name, String surname, String email, String password, String phone, LocalDate dateOfBirth) {
        this.name = name;
        this.surname = surname;
        this.password = password;
        this.email = email;
        this.phone = phone;
        this.dateOfBirth = dateOfBirth;
    }

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long usersId;

    private String name;
    private String surname;
    private String email;
    private String password;
    private String phone;
    private LocalDate dateOfBirth;

}
