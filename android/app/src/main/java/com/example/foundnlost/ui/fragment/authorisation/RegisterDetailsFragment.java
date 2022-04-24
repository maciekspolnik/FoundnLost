package com.example.foundnlost.ui.fragment.authorisation;

import android.content.DialogInterface;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.foundnlost.ui.activity.StartActivity;
import com.example.foundnlost.databinding.FragmentRegisterDetailsBinding;
import com.example.foundnlost.ui.fragment.dialog.DatePickingDialogFragment;
import com.example.foundnlost.viewModel.RegisterViewModel;

public class RegisterDetailsFragment extends Fragment {

    RegisterViewModel viewModel;
    FragmentRegisterDetailsBinding binding;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        viewModel = new ViewModelProvider(requireActivity()).get(RegisterViewModel.class);
        binding = FragmentRegisterDetailsBinding.inflate(inflater, container, false);

        binding.datePickerButton.setOnClickListener(view -> showDatePickingDialog());

        return binding.getRoot();
    }

    private void showDatePickingDialog() {
        DatePickingDialogFragment dialog = new DatePickingDialogFragment();
        dialog.setOnDismissListener(dialogInterface -> {
            binding.registerDetailsDateEditText.setText(dialog.getDate());
        });
        dialog.show(requireActivity().getSupportFragmentManager(), "DatePickingDialog");
    }
}