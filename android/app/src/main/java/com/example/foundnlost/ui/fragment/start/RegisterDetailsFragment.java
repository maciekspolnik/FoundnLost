package com.example.foundnlost.ui.fragment.start;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.foundnlost.R;
import com.example.foundnlost.databinding.FragmentRegisterDetailsBinding;
import com.example.foundnlost.ui.fragment.FlowFragment;
import com.example.foundnlost.ui.fragment.dialog.DatePickingDialog;
import com.example.foundnlost.viewModel.RegisterViewModel;
import com.example.foundnlost.viewModel.factory.ViewModelFactory;
import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.textfield.TextInputLayout;

public class RegisterDetailsFragment extends FlowFragment {

    RegisterViewModel viewModel;
    FragmentRegisterDetailsBinding binding;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

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
                Snackbar.make(requireView(), getText(R.string.registration_successful),Snackbar.LENGTH_LONG).show();
                onFragmentChangeRequestListener.onFragmentChangeRequest(new LoginFragment());
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
        DatePickingDialog dialog = new DatePickingDialog();
        dialog.setOnDismissListener(dialogInterface -> binding.registerDetailsDateEditText.setText(dialog.getDate()));
        dialog.show(requireActivity().getSupportFragmentManager(), "DatePickingDialog");
    }
}