package com.example.foundnlostbackend.data;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Date;

@Data
@AllArgsConstructor
public class AddAdvert {

    private Long userId;
    private String postType;
    private String title;
    private String description;
    private Date date;
    private String location;

}
