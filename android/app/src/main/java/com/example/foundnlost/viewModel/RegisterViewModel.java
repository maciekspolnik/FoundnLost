package com.example.foundnlost.viewModel;

import android.content.SharedPreferences;
import androidx.lifecycle.MutableLiveData;

import com.example.foundnlost.data.database.DatabaseHelper;
import com.example.foundnlost.data.network.config.ApiHelper;
import com.example.foundnlost.data.network.config.ApiHelperImpl;
import com.example.foundnlost.data.network.dto.Resource;
import com.example.foundnlost.data.network.dto.UserDto;
import com.example.foundnlost.data.network.dto.UserResponse;
import com.example.foundnlost.util.Mapper;
import com.example.foundnlost.viewModel.factory.DisposableViewModel;

import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.schedulers.Schedulers;
import timber.log.Timber;

public class RegisterViewModel extends DisposableViewModel {

    private final DatabaseHelper databaseHelper;
    private final ApiHelper apiHelper = new ApiHelperImpl();


    private String email;
    private String password;
    private String name;
    private String surname;
    private String phoneNumber;
    private String dateOfBirth;

    private MutableLiveData<Resource<UserResponse>> registrationResponse;

    public RegisterViewModel(DatabaseHelper databaseHelper) {
        this.databaseHelper = databaseHelper;
    }

    public MutableLiveData<Resource<UserResponse>> register() {
        if (registrationResponse == null) {
            registrationResponse = new MutableLiveData<>();
        }

        addDisposable(apiHelper.register(new UserDto(
                name, surname, email, password, phoneNumber, dateOfBirth))
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(this::consumeResponse, Timber::d));
        return registrationResponse;
    }

    private void consumeResponse(Resource<UserResponse> response) {
        registrationResponse.setValue(response);
//        addDisposable(databaseHelper.insertUser(Mapper.getUserEntity(response.getResult()))
//                .subscribeOn(Schedulers.io())
//                .observeOn(AndroidSchedulers.mainThread())
//                .subscribe(() -> Timber.d("Successfully inserted user")));

    }

    public void setRegisterDetails(String email, String password) {
        this.email = email;
        this.password = password;
    }

    public void setRegisterDetails(String name, String surname, String phoneNumber, String dateOfBirth) {
        this.name = name;
        this.surname = surname;
        this.phoneNumber = phoneNumber;
        this.dateOfBirth = dateOfBirth;
    }

}