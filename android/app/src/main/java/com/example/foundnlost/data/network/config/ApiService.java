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
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface ApiService {

    @POST("auth/register")
    Single<Resource<UserResponse>> register(@Body UserDto user);

    @POST("auth/login")
    Single<Resource<String>> login(@Body LoginRequest loginRequest);

    @GET("auth/token/valid/")
    Single<Resource<Boolean>> isTokenValid(@Query("email") String email, @Query("token") String token);

    @GET("users/")
    Single<UserDto> getUserById(@Query("index") int index);

    @GET("users/contact_data")
    Single<Resource<ContactDataDto>> getContactData(@Query("index") Long index);

    @POST("advert/")
    Single<Resource<AdvertDto>> addAdvert(@Body NewAdvert advert);

    @DELETE("advert/")
    Single<AdvertDto> deleteAdvert(Long id);

    @GET("advert/find_by_id")
    Single<ArrayList<AdvertDto>> getAdvertsById(@Query("index") Long id);

    @GET("advert/")
    Single<List<AdvertDto>> getAllAdverts();

}
