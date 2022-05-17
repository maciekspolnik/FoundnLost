package com.example.foundnlost.viewModel;

import android.content.SharedPreferences;

import androidx.lifecycle.MutableLiveData;

import com.example.foundnlost.data.database.DatabaseHelper;
import com.example.foundnlost.data.network.config.ApiHelper;
import com.example.foundnlost.data.network.config.ApiHelperImpl;
import com.example.foundnlost.data.network.dto.AdvertDto;
import com.example.foundnlost.data.network.dto.NewAdvert;
import com.example.foundnlost.data.network.dto.Resource;
import com.example.foundnlost.viewModel.factory.DisposableViewModel;

import java.util.Date;

import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.schedulers.Schedulers;

public class AddAdvertDialogViewModel extends DisposableViewModel {
    private final SharedPreferences preferencesHelper;
    private final DatabaseHelper databaseHelper;
    private final ApiHelper apiHelper = new ApiHelperImpl();
    private MutableLiveData<Resource<AdvertDto>> dataResponse;
    private String postType;
    private String title;
    private String description;
    private String date;
    private String location;

    public AddAdvertDialogViewModel(DatabaseHelper databaseHelper, SharedPreferences preferencesHelper) {
        this.databaseHelper = databaseHelper;
        this.preferencesHelper = preferencesHelper;
    }

    public void setData(String postType, String title, String description, String date, String location) {
        this.postType = postType;
        this.title = title;
        this.description = description;
        this.date = date;
        this.location = location;

    }

    public MutableLiveData<Resource<AdvertDto>> addNewAdvert() {
        if (dataResponse == null) {
            dataResponse = new MutableLiveData<>();
        }
        NewAdvert advertDto = new NewAdvert(
                preferencesHelper.getLong("userId", 0),
                postType,
                title,
                description,
                date,
                location
        );

        addDisposable(apiHelper.addAdvert(advertDto)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(response -> dataResponse.setValue(response), System.out::println));
        return dataResponse;
    }


}