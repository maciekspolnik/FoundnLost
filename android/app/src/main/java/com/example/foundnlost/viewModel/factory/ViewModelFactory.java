package com.example.foundnlost.viewModel.factory;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import com.example.foundnlost.data.database.DatabaseHelper;
import com.example.foundnlost.data.database.DatabaseHelperImpl;
import com.example.foundnlost.viewModel.RegisterViewModel;

import java.util.Objects;

public class ViewModelFactory implements ViewModelProvider.Factory {

    private final DatabaseHelper databaseHelper;

    public ViewModelFactory(Context context) {

        this.databaseHelper = new DatabaseHelperImpl(context);
    }

    @NonNull
    @Override
    public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {

        if (modelClass.isAssignableFrom(RegisterViewModel.class)) {
            return Objects.requireNonNull(modelClass.cast(new RegisterViewModel(databaseHelper)));
        }

        throw new IllegalArgumentException("Wrong viewModel class");
    }
}
