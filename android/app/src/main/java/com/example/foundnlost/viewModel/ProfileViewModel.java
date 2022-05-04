package com.example.foundnlost.viewModel;

import androidx.lifecycle.ViewModel;

import com.example.foundnlost.data.database.DatabaseHelper;

public class ProfileViewModel extends ViewModel {
    private final DatabaseHelper databaseHelper;

    public ProfileViewModel(DatabaseHelper databaseHelper) {
        this.databaseHelper = databaseHelper;
    }
}