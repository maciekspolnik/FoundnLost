package com.example.foundnlostbackend.model;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Entity
@Getter
@Setter
@RequiredArgsConstructor
public class Advert {

    public Advert(Users user, String postType, String title, String description, Date date, String location) {
        this.postType = postType;
        this.user = user;
        this.title = title;
        this.description = description;
        this.date = date;
        this.location = location;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long advertId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private Users user;

    private String postType;
    private String title;
    private String description;
    private Date date;
    private String location;


}
