package com.example.foundnlost.data.network.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class NewAdvert {

    private Long userId;
    private String postType;
    private String title;
    private String description;
    private String date;
    private String location;
}