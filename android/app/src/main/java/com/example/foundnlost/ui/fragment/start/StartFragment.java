package com.example.foundnlost.ui.fragment.start;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.example.foundnlost.ui.activity.StartActivity;
import com.example.foundnlost.databinding.FragmentStartBinding;
import com.example.foundnlost.ui.fragment.FlowFragment;

public class StartFragment extends FlowFragment {

    private FragmentStartBinding binding;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentStartBinding.inflate(inflater, container, false);

        binding.startLoginButton.setOnClickListener(view -> onFragmentChangeRequestListener.onFragmentChangeRequest(new LoginFragment()));
        binding.startRegisterButton.setOnClickListener(view -> onFragmentChangeRequestListener.onFragmentChangeRequest(new RegisterFragment()));

        return binding.getRoot();
    }


}