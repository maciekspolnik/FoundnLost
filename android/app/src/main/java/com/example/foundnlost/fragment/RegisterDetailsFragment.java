package com.example.foundnlost.fragment;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.foundnlost.activity.StartActivity;
import com.example.foundnlost.R;
import com.example.foundnlost.databinding.FragmentRegisterDetailsBinding;
import com.example.foundnlost.fragment.dialog.DatePickingDialogFragment;
import com.example.foundnlost.viewModel.RegisterViewModel;

public class RegisterDetailsFragment extends Fragment {

    RegisterViewModel viewModel;
    FragmentRegisterDetailsBinding binder;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        viewModel = new ViewModelProvider(this).get(RegisterViewModel.class);
        binder = FragmentRegisterDetailsBinding.inflate(inflater, container, false);

        binder.datePickerButton.setOnClickListener(v -> ((StartActivity) requireActivity()).showDialog(new DatePickingDialogFragment()));

        return binder.getRoot();
    }
}