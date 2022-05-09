package com.example.foundnlost.data.network.config;

import com.example.foundnlost.data.network.dto.AdvertDto;
import com.example.foundnlost.data.network.dto.ContactDataDto;
import com.example.foundnlost.data.network.dto.LoginRequest;
import com.example.foundnlost.data.network.dto.Response;
import com.example.foundnlost.data.network.dto.UserDto;
import com.example.foundnlost.data.network.model.Advert;
import com.example.foundnlost.data.network.model.Users;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.rxjava3.core.Single;

public interface ApiHelper {

    Single<Response<Users>> register(UserDto user);

    Single<Response<String>> login(LoginRequest loginRequest);

    Response<Boolean> isTokenValid(String email, String token);

    Single<UserDto> getUsers(int index);

    Single<Response<ContactDataDto>> getContactData(Long index);

    Single<Boolean> isEmailAvailable(String email);

    Single<AdvertDto> addAdvert(Advert advert);

    Single<AdvertDto> deleteAdvert(Long position);

    Single<ArrayList<AdvertDto>> getAdvertsById(Long id);

    Single<List<AdvertDto>> getAllAdverts();

}
