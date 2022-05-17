package com.example.foundnlostbackend.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Entity
@Getter
@Setter
@AllArgsConstructor
public class Users {

    public Users() {
    }

    public Users(
            String name, String surname, String email,
            String password, String phone, Date dateOfBirth) {
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
    @Column
    private String name;
    @Column
    private String surname;
    @Column
    private String email;
    @Column
    private String password;
    @Column
    private String phone;
    @Column
    private Date dateOfBirth;

}
