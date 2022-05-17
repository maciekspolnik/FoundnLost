package com.example.foundnlost.viewModel;

import androidx.lifecycle.MutableLiveData;

import com.example.foundnlost.data.database.DatabaseHelper;
import com.example.foundnlost.data.network.config.ApiHelper;
import com.example.foundnlost.data.network.config.ApiHelperImpl;
import com.example.foundnlost.data.network.dto.AdvertDto;
import com.example.foundnlost.data.network.dto.ContactDataDto;
import com.example.foundnlost.data.network.dto.Resource;
import com.example.foundnlost.viewModel.factory.DisposableViewModel;

import java.util.List;

import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.schedulers.Schedulers;

public class MainViewModel extends DisposableViewModel {
    private final DatabaseHelper databaseHelper;
    private final ApiHelper apiHelper = new ApiHelperImpl();
    private MutableLiveData<List<AdvertDto>> dataResponse;
    private MutableLiveData<Resource<ContactDataDto>> contactDataResponse;


    public MainViewModel(DatabaseHelper databaseHelper) {
        this.databaseHelper = databaseHelper;
    }


    public MutableLiveData<List<AdvertDto>> getAdvertData() {
        if (dataResponse == null) {
            dataResponse = new MutableLiveData<>();
        }
        addDisposable(apiHelper.getAllAdverts()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(listResponse -> dataResponse.setValue(listResponse), System.out::println));
        return dataResponse;
    }

    public MutableLiveData<Resource<ContactDataDto>> getContactData(Long index) {
        if (contactDataResponse == null) {
            contactDataResponse = new MutableLiveData<>();
        }
        addDisposable(apiHelper.getContactData(index)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(response -> contactDataResponse.setValue(response), System.out::println));
        return contactDataResponse;
    }

}