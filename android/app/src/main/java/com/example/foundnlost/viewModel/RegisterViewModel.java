package com.example.foundnlost.viewModel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.foundnlost.data.database.DatabaseHelper;
import com.example.foundnlost.data.database.entity.UserEntity;
import com.example.foundnlost.viewModel.factory.DisposableViewModel;

import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.schedulers.Schedulers;
import okhttp3.Response;

public class RegisterViewModel extends DisposableViewModel {

    private DatabaseHelper databaseHelper;
    private String email;
    private String password;
    private String name;
    private String surname;
    private String phoneNumber;
    private String dateOfBirth;

    private MutableLiveData<Response> registrationResponse;

    public RegisterViewModel(DatabaseHelper databaseHelper) {
        this.databaseHelper = databaseHelper;
    }

    public LiveData<Response> register() {
        if (registrationResponse == null) {
            registrationResponse = new MutableLiveData<>();
        }
        //registrationResponse.setValue()
        return registrationResponse;
    }

    public void setLoginDetails(String email, String password) {
        this.email = email;
        this.password = password;
    }

    public void setLoginDetails(String name, String surname, String phoneNumber, String dateOfBirth) {
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
                .subscribe());
    }


}