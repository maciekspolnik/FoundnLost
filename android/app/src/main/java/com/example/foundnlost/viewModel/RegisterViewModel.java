package com.example.foundnlost.viewModel;

import androidx.lifecycle.MutableLiveData;

import com.example.foundnlost.data.database.DatabaseHelper;
import com.example.foundnlost.data.database.entity.UserEntity;
import com.example.foundnlost.data.network.config.ApiHelper;
import com.example.foundnlost.data.network.config.ApiHelperImpl;
import com.example.foundnlost.data.network.dto.Resource;
import com.example.foundnlost.data.network.dto.UserDto;
import com.example.foundnlost.viewModel.factory.DisposableViewModel;

import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.schedulers.Schedulers;

public class RegisterViewModel extends DisposableViewModel {


    private final DatabaseHelper databaseHelper;
    private final ApiHelper apiHelper = new ApiHelperImpl();

    private String email;
    private String password;
    private String name;
    private String surname;
    private String phoneNumber;
    private String dateOfBirth;

    private MutableLiveData<Resource> registrationResponse;

    public RegisterViewModel(DatabaseHelper databaseHelper) {
        this.databaseHelper = databaseHelper;
    }

    public MutableLiveData<Resource> register() {
        if (registrationResponse == null) {
            registrationResponse = new MutableLiveData<>();
        }

        addDisposable(apiHelper.register(new UserDto(
                name,
                surname,
                email,
                password,
                phoneNumber,
                dateOfBirth
        ))
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(response -> {
                    registrationResponse.setValue(response);
                }, System.out::println));

        return registrationResponse;
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

    private UserEntity getUserEntity() {
        UserEntity entity = new UserEntity();
        entity.setEmail(email);
        entity.setPassword(password);
        entity.setName(name);
        entity.setSurname(surname);
        entity.setPhoneNumber(phoneNumber);
        entity.setDateOfBirth(dateOfBirth);
        return entity;
    }


    public void saveUserToDatabase() {
        addDisposable(databaseHelper.insertUser(getUserEntity())
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(()-> System.out.println("XD")));
    }
}