package com.example.foundnlost.viewModel;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import androidx.lifecycle.ViewModel;

import com.example.foundnlost.data.database.AppDatabase;
import com.example.foundnlost.data.database.DatabaseHelper;
import com.example.foundnlost.util.Mapper;
import com.example.foundnlost.viewModel.factory.DisposableViewModel;
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.schedulers.Schedulers;
import timber.log.Timber;

public class ProfileViewModel extends DisposableViewModel {
    private final DatabaseHelper databaseHelper;
    private final SharedPreferences preferences;


    public ProfileViewModel(DatabaseHelper databaseHelper, SharedPreferences preferences) {
        this.preferences = preferences;
        this.databaseHelper = databaseHelper;
    }


    public void logout(Context context) {

    }

}