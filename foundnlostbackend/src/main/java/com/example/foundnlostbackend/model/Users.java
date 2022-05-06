package com.example.foundnlostbackend.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

@Entity
@Getter
@Setter
@AllArgsConstructor
public class Users {

    public Users(String name, String surname, String email, String password, String phone, Date dateOfBirth) {
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
    private Date dateOfBirth;

    public Users() {

    }
}
