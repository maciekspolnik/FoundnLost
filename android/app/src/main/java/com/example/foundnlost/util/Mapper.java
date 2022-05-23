package com.example.foundnlost.util;

import com.example.foundnlost.data.database.entity.UserEntity;
import com.example.foundnlost.data.network.dto.UserResponse;

public class Mapper {

    public static UserEntity getUserEntity(UserResponse response) {
        UserEntity entity = new UserEntity();
        entity.setUserId(response.getUserId());
        entity.setEmail(response.getEmail());
        entity.setPassword(response.getPassword());
        entity.setName(response.getName());
        entity.setSurname(response.getSurname());
        entity.setPhoneNumber(response.getPhone());
        entity.setDateOfBirth(response.getDateOfBirth().toString());
        return entity;
    }

}
