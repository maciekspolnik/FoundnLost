package com.example.foundnlost.fragment;

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
import com.example.foundnlost.activity.MainActivity;
import com.example.foundnlost.activity.StartActivity;
import com.example.foundnlost.databinding.FragmentLoginBinding;
import com.example.foundnlost.fragment.dialog.ForgotPasswordDialogFragment;
import com.example.foundnlost.util.ValidationUtil;
import com.example.foundnlost.viewModel.LoginViewModel;
import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.textfield.TextInputLayout;

public class LoginFragment extends Fragment {

    private LoginViewModel viewModel;
    private FragmentLoginBinding binder;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        binder = FragmentLoginBinding.inflate(inflater, container, false);
        viewModel = new ViewModelProvider(this).get(LoginViewModel.class);
        binder.loginButton.setOnClickListener(v -> {
            if (validateLength(binder.loginEmailTextInputLayout)
                    && validateLength(binder.loginPasswordTextInputLayout)
                    && ValidationUtil.isEmailValid(extractText(binder.loginEmailTextInputLayout))
                    && ValidationUtil.isPasswordValid(extractText(binder.loginPasswordTextInputLayout))
            ) {
                //TODO LOGIKA PODLACZENIA DO LOGOWANIA NA BACKENDZIE
                Intent intent = new Intent(requireActivity(), MainActivity.class);
                startActivity(intent);
            } else {
                binder.loginEmailTextInputLayout.setError("  ");
                binder.loginPasswordTextInputLayout.setError(getString(R.string.wrong_login_credentials));
            }
        });
        binder.appHeader.setBackClickedListener(v -> requireActivity().onBackPressed());
        assert binder.loginEmailTextInputLayout.getEditText() != null;
        assert binder.loginPasswordTextInputLayout.getEditText() != null;
        binder.loginEmailTextInputLayout.getEditText().addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                validateLength(binder.loginEmailTextInputLayout);
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
        binder.loginPasswordTextInputLayout.getEditText().addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                validateLength(binder.loginPasswordTextInputLayout);
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
        binder.forgotPasswordTextButton.setOnClickListener(v-> ((StartActivity) requireActivity()).showDialog(new ForgotPasswordDialogFragment()));

        return binder.getRoot();
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