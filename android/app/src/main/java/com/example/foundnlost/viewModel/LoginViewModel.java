package com.example.foundnlost.viewModel;

import android.content.SharedPreferences;

import android.util.Log;
import androidx.lifecycle.MutableLiveData;

import com.example.foundnlost.data.database.DatabaseHelper;
import com.example.foundnlost.data.network.config.ApiHelper;
import com.example.foundnlost.data.network.config.ApiHelperImpl;
import com.example.foundnlost.data.network.dto.LoginRequest;
import com.example.foundnlost.data.network.dto.Resource;
import com.example.foundnlost.data.network.dto.UserDto;
import com.example.foundnlost.util.JwtUtil;
import com.example.foundnlost.util.Mapper;
import com.example.foundnlost.viewModel.factory.DisposableViewModel;

import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.schedulers.Schedulers;
import timber.log.Timber;

public class LoginViewModel extends DisposableViewModel {

    private final DatabaseHelper databaseHelper;
    private final SharedPreferences preferences;
    private final ApiHelper apiHelper = new ApiHelperImpl();

    private String email;
    private String password;
    private Long uuid;

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
                .subscribe(this::handleResponse, (e) -> Timber.d(e.toString())));

        return loginResponse;
    }

    private void handleResponse(Resource<String> response) {


        loginResponse.setValue(response);
        SharedPreferences.Editor editor = preferences.edit();
        if (response.getResult() == null) {
            return;
        }
        uuid = JwtUtil.decodeUserInfo(response.getResult());

        editor.putLong("userId", uuid);
        editor.putString("userToken", response.getResult()).apply();
        editor.apply();

        addDisposable(apiHelper.getUsersById(uuid)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(this::addToDatabase, (e) -> Timber.e(e.toString())));
    }

    private void addToDatabase(UserDto userDto) {
        addDisposable(databaseHelper.insertUser(Mapper.getUserEntityFromDto(uuid, userDto))
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(() -> Timber.d("Successfully inserted user")));
    }


}

