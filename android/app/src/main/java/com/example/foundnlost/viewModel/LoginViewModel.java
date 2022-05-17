package com.example.foundnlost.viewModel;

import android.content.SharedPreferences;

import androidx.lifecycle.MutableLiveData;

import com.example.foundnlost.data.database.DatabaseHelper;
import com.example.foundnlost.data.network.config.ApiHelper;
import com.example.foundnlost.data.network.config.ApiHelperImpl;
import com.example.foundnlost.data.network.dto.LoginRequest;
import com.example.foundnlost.data.network.dto.Resource;
import com.example.foundnlost.util.JwtUtil;
import com.example.foundnlost.viewModel.factory.DisposableViewModel;

import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.schedulers.Schedulers;

public class LoginViewModel extends DisposableViewModel {

    private final DatabaseHelper databaseHelper;
    private final SharedPreferences preferences;
    private final ApiHelper apiHelper = new ApiHelperImpl();

    private String email;
    private String password;

    private MutableLiveData<Resource<String>> loginResponse;

    public LoginViewModel(DatabaseHelper databaseHelper, SharedPreferences preferences) {
        this.databaseHelper = databaseHelper;
        this.preferences = preferences;
    }

    public void setLoginDetails(String email, String password) {
        this.email = email;
        this.password = password;
    }

    public MutableLiveData<Resource<String>> login() {
        if (loginResponse == null) {
            loginResponse = new MutableLiveData<>();
        }

        addDisposable(apiHelper.login(new LoginRequest(email, password))
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(this::handleResponse, System.out::println));

        return loginResponse;
    }

    private void handleResponse(Resource<String> response) {
        loginResponse.setValue(response);
        SharedPreferences.Editor editor = preferences.edit();
        editor.putLong("userId", JwtUtil.decodeUserInfo(response.getResult()));
        editor.putString("userToken", response.getResult()).apply();
        editor.apply();
    }

}

