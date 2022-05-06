package com.example.foundnlost.data.network.config;

import com.example.foundnlost.data.network.dto.AdvertDto;
import com.example.foundnlost.data.network.dto.ContactDataDto;
import com.example.foundnlost.data.network.dto.LoginRequest;
import com.example.foundnlost.data.network.dto.Response;
import com.example.foundnlost.data.network.dto.UserDto;
import com.example.foundnlost.data.network.model.Advert;
import com.example.foundnlost.data.network.model.Users;

import java.util.List;

import io.reactivex.rxjava3.core.Single;

public interface ApiHelper {

    Single<Response<Users>> register(UserDto user);

    Response<String> login(LoginRequest loginRequest);

    Response<Boolean> isTokenValid(String email, String token);

    Single<UserDto> getUsers(int index);

    Single<ContactDataDto> getContactData(int index);

    Single<Response<UserDto>> registerUser(Users user);

    Single<Boolean> isEmailAvailable(String email);

    Single<AdvertDto> addAdvert(Advert advert);

    Single<AdvertDto> deleteAdvert();

    Single<List<AdvertDto>> findAdvertByUserId(Long id);

    Single<List<AdvertDto>> findAdvertByType(String type);

}
