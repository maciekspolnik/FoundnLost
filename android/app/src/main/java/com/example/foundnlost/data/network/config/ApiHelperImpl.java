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

public class ApiHelperImpl implements ApiHelper {
    @Override
    public Single<Response<Users>> register(UserDto user) {
        ApiService apiService = RetrofitClient.getInstance().getApiService();
        return apiService.register(user);
    }

    @Override
    public Response<String> login(LoginRequest loginRequest) {
        return null;
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
    public Single<ContactDataDto> getContactData(int index) {
        return null;
    }

    @Override
    public Single<Response<UserDto>> registerUser(Users user) {
        return null;
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
    public Single<AdvertDto> deleteAdvert() {
        return null;
    }

    @Override
    public Single<List<AdvertDto>> findAdvertByUserId(Long id) {
        return null;
    }

    @Override
    public Single<List<AdvertDto>> findAdvertByType(String type) {
        return null;
    }
}
