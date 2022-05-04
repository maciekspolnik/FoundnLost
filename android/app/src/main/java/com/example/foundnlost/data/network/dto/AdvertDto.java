package com.example.foundnlost.data.network.dto;

import java.util.Date;

import lombok.Data;

@Data
public class AdvertDto {
    private Long userId;
    private String postType;
    private String title;
    private String description;
    private Date date;
    private String location;
}
