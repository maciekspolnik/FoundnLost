package com.example.foundnlost.viewModel;

import androidx.lifecycle.ViewModel;

import com.example.foundnlost.data.database.DatabaseHelper;

public class AddAdvertDialogViewModel extends ViewModel {
    private DatabaseHelper databaseHelper;

    public AddAdvertDialogViewModel(DatabaseHelper databaseHelper) {
        this.databaseHelper = databaseHelper;
    }
}