package com.example.foundnlost.data.network.dto;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class AdvertDto {
    private Long advertId;
    private Long userId;
    private String postType;
    private String title;
    private String description;
    private Date date;
    private String location;
}
