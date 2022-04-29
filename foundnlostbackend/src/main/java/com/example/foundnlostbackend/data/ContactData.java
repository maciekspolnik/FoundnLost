package com.example.foundnlostbackend.data;


import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class ContactData {
    String name;
    String surname;
    String phoneNumber;
}
