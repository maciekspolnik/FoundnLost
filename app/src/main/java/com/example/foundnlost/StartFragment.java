package com.example.foundnlost;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

public class StartFragment extends Fragment {

    Button loginButton;
    Button registerButton;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_start, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        loginButton = requireActivity().findViewById(R.id.startLoginButton);
        registerButton = requireActivity().findViewById(R.id.startRegisterButton);
        loginButton.setOnClickListener(v -> ((MainActivity) requireActivity()).displayFragment(new LoginFragment()));
        registerButton.setOnClickListener(v -> ((MainActivity) requireActivity()).displayFragment(new RegisterFragment()));

    }
}