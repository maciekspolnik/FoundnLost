package com.example.foundnlost.ui.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.foundnlost.R;
import com.example.foundnlost.ui.activity.MainActivity;
import com.example.foundnlost.ui.activity.StartActivity;
import com.example.foundnlost.databinding.FragmentLoginBinding;
import com.example.foundnlost.ui.fragment.dialog.ForgotPasswordDialogFragment;
import com.example.foundnlost.util.ValidationUtil;
import com.example.foundnlost.viewModel.LoginViewModel;
import com.google.android.material.textfield.TextInputLayout;

public class LoginFragment extends Fragment {

    private LoginViewModel viewModel;
    private FragmentLoginBinding binding;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        binding = FragmentLoginBinding.inflate(inflater, container, false);
        viewModel = new ViewModelProvider(this).get(LoginViewModel.class);
        binding.loginButton.setOnClickListener(v -> {
            if (validateLength(binding.loginEmailTextInputLayout)
                    && validateLength(binding.loginPasswordTextInputLayout)
                    && ValidationUtil.isEmailValid(extractText(binding.loginEmailTextInputLayout))
                    && ValidationUtil.isPasswordValid(extractText(binding.loginPasswordTextInputLayout))
            ) {
                //TODO LOGIKA PODLACZENIA DO LOGOWANIA NA BACKENDZIE
                Intent intent = new Intent(requireActivity(), MainActivity.class);
                startActivity(intent);
            } else {
                binding.loginEmailTextInputLayout.setError(" ");
                binding.loginPasswordTextInputLayout.setError(getString(R.string.wrong_login_credentials));
            }
        });
        binding.appHeader.setBackClickedListener(v -> requireActivity().onBackPressed());
        binding.loginEmailEditText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                validateLength(binding.loginEmailTextInputLayout);
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
        binding.loginPasswordEditText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                validateLength(binding.loginPasswordTextInputLayout);
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        binding.forgotPasswordTextButton.setOnClickListener(v-> ((StartActivity) requireActivity()).showDialog(new ForgotPasswordDialogFragment()));

        return binding.getRoot();
    }

    private String extractText(TextInputLayout textInputLayout) {
        if (textInputLayout.getEditText() != null) {
            return textInputLayout.getEditText().getText().toString();
        }
        return "";
    }

    private boolean validateLength(TextInputLayout layout) {
        if (extractText(layout).isEmpty()) {
            layout.setError(getText(R.string.field_cannot_be_empty));
            return false;
        }
        layout.setError(null);
        return true;
    }

}