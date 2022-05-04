package com.example.foundnlost.viewModel;

import androidx.lifecycle.ViewModel;

import com.example.foundnlost.data.database.DatabaseHelper;

public class ContactInfoDialogViewModel extends ViewModel {
    private final DatabaseHelper databaseHelper;

    public ContactInfoDialogViewModel(DatabaseHelper databaseHelper) {
        this.databaseHelper = databaseHelper;
    }
    // TODO: Implement the ViewModel
}