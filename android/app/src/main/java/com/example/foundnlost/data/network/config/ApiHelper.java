package com.example.foundnlost.data.network.config;

import com.example.foundnlost.data.network.dto.AdvertDto;
import com.example.foundnlost.data.network.dto.ContactDataDto;
import com.example.foundnlost.data.network.dto.LoginRequest;
import com.example.foundnlost.data.network.dto.NewAdvert;
import com.example.foundnlost.data.network.dto.Resource;
import com.example.foundnlost.data.network.dto.UserDto;
import com.example.foundnlost.data.network.dto.UserResponse;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.rxjava3.core.Single;

public interface ApiHelper {

    Single<Resource<UserResponse>> register(UserDto user);

    Single<Resource<String>> login(LoginRequest loginRequest);

    Single<Resource<Boolean>> isTokenValid(String email, String token);

    Single<Resource<ContactDataDto>> getContactData(Long index);

    Single<Resource<AdvertDto>> addAdvert(NewAdvert advert);

    Single<AdvertDto> deleteAdvert(Long position);

    Single<ArrayList<AdvertDto>> getAdvertsById(Long id);

    Single<UserDto> getUsersById(Long id);

    Single<List<AdvertDto>> getAllAdverts();

}
