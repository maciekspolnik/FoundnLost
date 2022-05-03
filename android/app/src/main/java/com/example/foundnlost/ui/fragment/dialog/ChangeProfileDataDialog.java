package com.example.foundnlost.ui.fragment.dialog;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.foundnlost.databinding.DialogChangeProfileDataBinding;
import com.example.foundnlost.viewModel.ChangeProfileDataViewModel;
import com.example.foundnlost.viewModel.factory.ViewModelFactory;

public class ChangeProfileDataDialog extends DialogFragment {

    private ChangeProfileDataViewModel viewModel;
    private DialogChangeProfileDataBinding binding;


    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = DialogChangeProfileDataBinding.inflate(inflater, container, false);
        viewModel = new ViewModelProvider(this, new ViewModelFactory(requireContext())).get(ChangeProfileDataViewModel.class);
        binding.cancelButton.setOnClickListener(view -> dismiss());
        setCancelable(false);
        return binding.getRoot();
    }
}