package com.example.foundnlost.viewModel;

import androidx.lifecycle.ViewModel;

import com.example.foundnlost.data.database.DatabaseHelper;

public class ChangeProfileDataViewModel extends ViewModel {
    private DatabaseHelper databaseHelper;

    public ChangeProfileDataViewModel(DatabaseHelper databaseHelper) {
        this.databaseHelper = databaseHelper;
    }
}