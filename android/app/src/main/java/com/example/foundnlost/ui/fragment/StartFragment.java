package com.example.foundnlost.ui.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.example.foundnlost.ui.activity.StartActivity;
import com.example.foundnlost.databinding.FragmentStartBinding;

public class StartFragment extends Fragment {

    private FragmentStartBinding binding;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentStartBinding.inflate(inflater, container, false);

        binding.startLoginButton.setOnClickListener(v -> ((StartActivity) requireActivity()).displayFragment(new LoginFragment()));
        binding.startRegisterButton.setOnClickListener(v -> ((StartActivity) requireActivity()).displayFragment(new RegisterFragment()));

        return binding.getRoot();
    }


}