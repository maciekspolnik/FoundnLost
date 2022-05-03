package com.example.foundnlost.data.network.model;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;

@Data
@AllArgsConstructor
public class Advert {

    public Advert(Long userId, String postType, String title, String description, Date date, String location) {
        this.userId = userId;
        this.postType = postType;
        this.title = title;
        this.description = description;
        this.date = date;
        this.location = location;
    }

    private Long advertId;
    private Long userId;
    private String postType;
    private String title;
    private String description;
    private Date date;
    private String location;
}
