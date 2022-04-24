package com.example.foundnlost.viewModel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.foundnlost.viewModel.factory.DisposableViewModel;

import okhttp3.Response;

public class RegisterViewModel extends DisposableViewModel {

    private MutableLiveData<String> nameLiveData;
    private MutableLiveData<String> surnameLiveData;
    private MutableLiveData<String> emailLiveData;
    private MutableLiveData<Response> registrationResponse;

    public LiveData<Response> register() {
        if (registrationResponse == null) {
            registrationResponse = new MutableLiveData<>();
        }
        //registrationResponse.setValue()
        return registrationResponse;
    }


}