package com.example.foundnlost.viewModel.factory;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import com.example.foundnlost.data.database.DatabaseHelper;
import com.example.foundnlost.data.database.DatabaseHelperImpl;
import com.example.foundnlost.viewModel.AddAdvertDialogViewModel;
import com.example.foundnlost.viewModel.ChangeProfileDataViewModel;
import com.example.foundnlost.viewModel.ContactInfoDialogViewModel;
import com.example.foundnlost.viewModel.MainViewModel;
import com.example.foundnlost.viewModel.LoginViewModel;
import com.example.foundnlost.viewModel.ManageAdvertsViewModel;
import com.example.foundnlost.viewModel.ProfileViewModel;
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

        if (modelClass.isAssignableFrom(AddAdvertDialogViewModel.class)) {
            return Objects.requireNonNull(modelClass.cast(new AddAdvertDialogViewModel(databaseHelper)));
        }
        if (modelClass.isAssignableFrom(ChangeProfileDataViewModel.class)) {
            return Objects.requireNonNull(modelClass.cast(new ChangeProfileDataViewModel(databaseHelper)));
        }
        if (modelClass.isAssignableFrom(ContactInfoDialogViewModel.class)) {
            return Objects.requireNonNull(modelClass.cast(new ContactInfoDialogViewModel(databaseHelper)));
        }
        if (modelClass.isAssignableFrom(LoginViewModel.class)) {
            return Objects.requireNonNull(modelClass.cast(new LoginViewModel(databaseHelper)));
        }
        if (modelClass.isAssignableFrom(MainViewModel.class)) {
            return Objects.requireNonNull(modelClass.cast(new MainViewModel(databaseHelper)));
        }
        if (modelClass.isAssignableFrom(ManageAdvertsViewModel.class)) {
            return Objects.requireNonNull(modelClass.cast(new ManageAdvertsViewModel(databaseHelper)));
        }
        if (modelClass.isAssignableFrom(RegisterViewModel.class)) {
            return Objects.requireNonNull(modelClass.cast(new RegisterViewModel(databaseHelper)));
        }
        if (modelClass.isAssignableFrom(ProfileViewModel.class)) {
            return Objects.requireNonNull(modelClass.cast(new ProfileViewModel(databaseHelper)));
        }
        if (modelClass.isAssignableFrom(ChangeProfileDataViewModel.class)) {
            return Objects.requireNonNull(modelClass.cast(new ChangeProfileDataViewModel(databaseHelper)));
        }
        if (modelClass.isAssignableFrom(ChangeProfileDataViewModel.class)) {
            return Objects.requireNonNull(modelClass.cast(new ChangeProfileDataViewModel(databaseHelper)));
        }
        if (modelClass.isAssignableFrom(ChangeProfileDataViewModel.class)) {
            return Objects.requireNonNull(modelClass.cast(new ChangeProfileDataViewModel(databaseHelper)));
        }

        throw new IllegalArgumentException("Wrong viewModel class");
    }
}
