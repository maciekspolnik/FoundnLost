package com.example.foundnlost.viewModel;

import androidx.lifecycle.ViewModel;

import com.example.foundnlost.data.database.DatabaseHelper;

public class LoginViewModel extends ViewModel {
 private DatabaseHelper databaseHelper;



    public LoginViewModel(DatabaseHelper databaseHelper) {
        this.databaseHelper = databaseHelper;
    }

    public void login(){}

}