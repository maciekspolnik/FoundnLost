package com.example.foundnlostbackend.mapper;

import com.example.foundnlostbackend.data.AddAdvert;
import com.example.foundnlostbackend.model.Advert;
import com.example.foundnlostbackend.model.Users;

public class AdvertMapper {

    public static Advert mapToAdvert(AddAdvert data, Users user){
         return new Advert(
                user,
                data.getPostType(),
                data.getTitle(),
                data.getDescription(),
                null,
                data.getLocation()
        );
    }
}
