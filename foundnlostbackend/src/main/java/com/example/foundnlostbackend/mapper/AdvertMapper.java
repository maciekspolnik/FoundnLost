package com.example.foundnlostbackend.mapper;

import com.example.foundnlostbackend.data.AddAdvert;
import com.example.foundnlostbackend.data.AdvertData;
import com.example.foundnlostbackend.model.Advert;
import com.example.foundnlostbackend.model.Users;

import java.util.ArrayList;
import java.util.List;

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

    public static AdvertData mapToAdvertData(Advert advert) {
        return new AdvertData(
                advert.getUser().getUsersId(),
                advert.getPostType(),
                advert.getTitle(),
                advert.getDescription(),
                advert.getDate(),
                advert.getLocation());
    }

    public static List<AdvertData> mapToAdvertDataList(Iterable<Advert> adverts) {
        List<AdvertData> list = new ArrayList<>();
        for (Advert a : adverts) {
            list.add(mapToAdvertData(a));
        }
        return list;
    }


}
