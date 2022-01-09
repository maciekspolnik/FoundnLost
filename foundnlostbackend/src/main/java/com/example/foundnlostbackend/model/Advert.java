package com.example.foundnlostbackend.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDate;

@Entity
public class Advert {


    public Advert() {
    }

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

    public Long getAdvertId() {
        return advertId;
    }

    public void setAdvertId(Long advert_id) {
        this.advertId = advert_id;
    }

    public String getPostType() {
        return postType;
    }

    public void setPostType(String post_type) {
        this.postType = post_type;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }
}
