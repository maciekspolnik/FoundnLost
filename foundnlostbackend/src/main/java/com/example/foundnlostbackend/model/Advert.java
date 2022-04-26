package com.example.foundnlostbackend.model;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDate;

@Entity
@Getter
@Setter
@ToString
@RequiredArgsConstructor
public class Advert {

    public Advert(String postType, String title, String description, LocalDate date, String location) {
        this.postType = postType;
        this.title = title;
        this.description = description;
        this.date = date;
        this.location = location;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long advertId;
    private String postType;
    private String title;
    private String description;
    private LocalDate date;
    private String location;


}
