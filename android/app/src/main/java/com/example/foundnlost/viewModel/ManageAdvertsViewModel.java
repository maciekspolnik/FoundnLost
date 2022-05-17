package com.example.foundnlost.viewModel;

import android.content.SharedPreferences;

import androidx.lifecycle.MutableLiveData;

import com.example.foundnlost.data.database.DatabaseHelper;
import com.example.foundnlost.data.network.config.ApiHelper;
import com.example.foundnlost.data.network.config.ApiHelperImpl;
import com.example.foundnlost.data.network.dto.AdvertDto;
import com.example.foundnlost.viewModel.factory.DisposableViewModel;

import java.util.ArrayList;

import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.schedulers.Schedulers;

public class ManageAdvertsViewModel extends DisposableViewModel {
    private final SharedPreferences preferencesHelper;
    private final DatabaseHelper databaseHelper;
    private MutableLiveData<ArrayList<AdvertDto>> dataResponse;
    private final ApiHelper apiHelper = new ApiHelperImpl();

    public ManageAdvertsViewModel(DatabaseHelper databaseHelper, SharedPreferences preferencesHelper) {
        this.databaseHelper = databaseHelper;
        this.preferencesHelper = preferencesHelper;
    }

    public MutableLiveData<ArrayList<AdvertDto>> getAdvertData() {
        if (dataResponse == null) {
            dataResponse = new MutableLiveData<>();
        }

        addDisposable(apiHelper.getAdvertsById(1L)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(listResponse -> dataResponse.setValue(listResponse), System.out::println));
        return dataResponse;
    }

    public void deleteAdvert(int position) {
        addDisposable(apiHelper.deleteAdvert((long) position)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(System.out::println, System.out::println));
    }
}