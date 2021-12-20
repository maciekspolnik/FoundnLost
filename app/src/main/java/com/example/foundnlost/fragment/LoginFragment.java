package com.example.foundnlost.fragment;

import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.foundnlost.R;
import com.example.foundnlost.viewModel.LoginViewModel;

public class LoginFragment extends Fragment {

    private LoginViewModel viewModel;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        viewModel = new ViewModelProvider(this).get(LoginViewModel.class);
        return inflater.inflate(R.layout.fragment_login, container, false);
    }
}