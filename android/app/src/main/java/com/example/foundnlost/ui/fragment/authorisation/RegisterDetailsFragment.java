package com.example.foundnlost.ui.fragment.authorisation;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.foundnlost.databinding.FragmentRegisterDetailsBinding;
import com.example.foundnlost.ui.fragment.dialog.DatePickingDialogFragment;
import com.example.foundnlost.viewModel.RegisterViewModel;
import com.example.foundnlost.viewModel.factory.ViewModelFactory;
import com.google.android.material.textfield.TextInputLayout;

public class RegisterDetailsFragment extends Fragment {

    RegisterViewModel viewModel;
    FragmentRegisterDetailsBinding binding;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        viewModel = new ViewModelProvider(requireActivity(), new ViewModelFactory(requireContext())).get(RegisterViewModel.class);
        binding = FragmentRegisterDetailsBinding.inflate(inflater, container, false);

        binding.datePickerButton.setOnClickListener(view -> showDatePickingDialog());

        binding.registrationButton.setOnClickListener(view -> {
            if (binding.registrationAgreementCheckBox.isChecked()) {
                viewModel.setLoginDetails(
                        extractText(binding.registerDetailsNameInputLayout),
                        extractText(binding.registerDetailsSurnameInputLayout),
                        extractText(binding.registerDetailsPhoneInputLayout),
                        extractText(binding.registerDetailsDateInputLayout)
                );
                viewModel.saveUserToDatabase();
            }
        });

        return binding.getRoot();
    }

    private String extractText(TextInputLayout textInputLayout) {
        if (textInputLayout.getEditText() != null) {
            return textInputLayout.getEditText().getText().toString();
        }
        return "";
    }


    private void showDatePickingDialog() {
        DatePickingDialogFragment dialog = new DatePickingDialogFragment();
        dialog.setOnDismissListener(dialogInterface -> binding.registerDetailsDateEditText.setText(dialog.getDate()));
        dialog.show(requireActivity().getSupportFragmentManager(), "DatePickingDialog");
    }
}