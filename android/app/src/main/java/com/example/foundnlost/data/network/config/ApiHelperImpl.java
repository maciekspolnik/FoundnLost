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

public class ApiHelperImpl implements ApiHelper {
    @Override
    public Single<Resource<UserResponse>> register(UserDto user) {
        ApiService apiService = RetrofitClient.getInstance().getApiService();
        return apiService.register(user);
    }

    @Override
    public Single<Resource<String>> login(LoginRequest loginRequest) {
        ApiService apiService = RetrofitClient.getInstance().getApiService();
        return apiService.login(loginRequest);
    }

    @Override
    public Single<Resource<Boolean>> isTokenValid(String email, String token) {
        ApiService apiService = RetrofitClient.getInstance().getApiService();
        return apiService.isTokenValid(email, token);
    }

    @Override
    public Single<Resource<ContactDataDto>> getContactData(Long index) {
        ApiService apiService = RetrofitClient.getInstance().getApiService();
        return apiService.getContactData(index);
    }

    @Override
    public Single<Resource<AdvertDto>> addAdvert(NewAdvert advert) {
        ApiService apiService = RetrofitClient.getInstance().getApiService();
        return apiService.addAdvert(advert);
    }

    @Override
    public Single<AdvertDto> deleteAdvert(Long position) {
        ApiService apiService = RetrofitClient.getInstance().getApiService();
        return apiService.deleteAdvert(position);
    }

    @Override
    public Single<ArrayList<AdvertDto>> getAdvertsById(Long id) {
        ApiService apiService = RetrofitClient.getInstance().getApiService();
        return apiService.getAdvertsById(id);
    }

    @Override
    public Single<UserDto> getUsersById(Long id) {
        ApiService apiService = RetrofitClient.getInstance().getApiService();
        return apiService.getUserById(id);
    }

    @Override
    public Single<List<AdvertDto>> getAllAdverts() {
        ApiService apiService = RetrofitClient.getInstance().getApiService();
        return apiService.getAllAdverts();
    }

}
