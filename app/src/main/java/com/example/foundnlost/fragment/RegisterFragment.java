package com.example.foundnlost.fragment;

import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.foundnlost.activity.StartActivity;
import com.example.foundnlost.R;
import com.example.foundnlost.viewModel.RegisterViewModel;

public class RegisterFragment extends Fragment {

    private RegisterViewModel viewModel;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        viewModel = new ViewModelProvider(this).get(RegisterViewModel.class);
        View view = inflater.inflate(R.layout.fragment_register, container, false);
        Button nextButton = view.findViewById(R.id.registerNextButton);
        nextButton.setOnClickListener(v -> ((StartActivity)requireActivity()).displayFragment(new RegisterDetailsFragment()));
        return view;
    }


}