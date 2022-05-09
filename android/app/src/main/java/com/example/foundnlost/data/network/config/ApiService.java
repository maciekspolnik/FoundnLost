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
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface ApiService {

    @POST("auth/register")
    Single<Response<Users>> register(@Body UserDto user);

    @POST("auth/login")
    Single<Response<String>> login(@Body LoginRequest loginRequest);

    @GET("auth/token/valid/")
    Single<Response<Boolean>> isTokenValid(@Query("email") String email, @Query("token") String token);

    @GET("users/")
    Single<UserDto> getUserById(@Query("index") int index);

    @GET("users/contact_data")
    Single<Response<ContactDataDto>> getContactData(@Query("index") Long index);

    @POST("advert/")
    Single<AdvertDto> addAdvert(@Body Advert advert);

    @DELETE("advert/")
    Single<AdvertDto> deleteAdvert(Long id);

    @GET("advert/find_by_id")
    Single<ArrayList<AdvertDto>> getAdvertsById(@Query("index") Long id);

    @GET("advert/")
    Single<List<AdvertDto>> getAllAdverts();

}
