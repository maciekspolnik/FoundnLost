package com.example.foundnlost;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.foundnlost.viewModel.RegisterViewModel;

public class RegisterDetailsFragment extends Fragment {

    RegisterViewModel viewModel;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        viewModel = new ViewModelProvider(this).get(RegisterViewModel.class);
        View view = inflater.inflate(R.layout.fragment_register_details, container, false);
        Button datePickerButton = view.findViewById(R.id.datePickerButton);
        datePickerButton.setOnClickListener(v -> ((MainActivity) requireActivity()).showDialog(new DatePickingDialogFragment()));

        return view;
    }
}