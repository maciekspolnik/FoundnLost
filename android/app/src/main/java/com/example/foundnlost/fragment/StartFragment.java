package com.example.foundnlost.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.example.foundnlost.activity.StartActivity;
import com.example.foundnlost.databinding.FragmentStartBinding;

public class StartFragment extends Fragment {

    private FragmentStartBinding binder;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binder = FragmentStartBinding.inflate(inflater, container, false);

        binder.startLoginButton.setOnClickListener(v -> ((StartActivity) requireActivity()).displayFragment(new LoginFragment()));
        binder.startRegisterButton.setOnClickListener(v -> ((StartActivity) requireActivity()).displayFragment(new RegisterFragment()));

        return binder.getRoot();
    }


}