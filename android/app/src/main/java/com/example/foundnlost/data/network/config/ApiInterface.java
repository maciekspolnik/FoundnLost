package com.example.foundnlost.data.network.config;

import com.example.foundnlost.data.network.dto.ContactDataDto;
import com.example.foundnlost.data.network.dto.UserDto;
import com.example.foundnlost.data.network.model.Users;

import io.reactivex.rxjava3.core.Completable;
import io.reactivex.rxjava3.core.Single;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface ApiInterface {

    @GET("/users/")
    Single<UserDto> getUsers(@Query("index") int index);

    @GET("/users/contactdata")
    Single<ContactDataDto> getContactData(@Query("index") int index);

    @POST("/users/")
    Completable registerUser(@Body Users user);

    @POST("/emailexists/")
    Single<Boolean> isEmailAvailable(@Query("email") String email);

}
