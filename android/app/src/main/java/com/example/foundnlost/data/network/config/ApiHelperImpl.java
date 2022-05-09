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

public class ApiHelperImpl implements ApiHelper {
    @Override
    public Single<Response<Users>> register(UserDto user) {
        ApiService apiService = RetrofitClient.getInstance().getApiService();
        return apiService.register(user);
    }

    @Override
    public Single<Response<String>> login(LoginRequest loginRequest) {
        ApiService apiService = RetrofitClient.getInstance().getApiService();
        return apiService.login(loginRequest);
    }

    @Override
    public Response<Boolean> isTokenValid(String email, String token) {
        return null;
    }

    @Override
    public Single<UserDto> getUsers(int index) {
        return null;
    }

    @Override
    public Single<Response<ContactDataDto>> getContactData(Long index) {
        ApiService apiService = RetrofitClient.getInstance().getApiService();
        return apiService.getContactData(index);
    }

    @Override
    public Single<Boolean> isEmailAvailable(String email) {
        return null;
    }

    @Override
    public Single<AdvertDto> addAdvert(Advert advert) {
        return null;
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
    public Single<List<AdvertDto>> getAllAdverts() {
        ApiService apiService = RetrofitClient.getInstance().getApiService();
        return apiService.getAllAdverts();
    }

}
