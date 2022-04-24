package com.example.foundnlost.viewModel.factory;

import androidx.lifecycle.ViewModel;

import io.reactivex.rxjava3.disposables.CompositeDisposable;
import io.reactivex.rxjava3.disposables.Disposable;

public class DisposableViewModel extends ViewModel {

    private final CompositeDisposable disposables = new CompositeDisposable();

    protected void addDisposable(Disposable disposable) {
        disposables.add(disposable);
    }

    @Override
    protected void onCleared() {
        disposables.dispose();
        super.onCleared();
    }
}
