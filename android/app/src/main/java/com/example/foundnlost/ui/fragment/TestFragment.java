package com.example.foundnlost.ui.fragment;

import android.os.Bundle;
import android.telephony.PhoneNumberFormattingTextWatcher;
import android.text.InputFilter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.example.foundnlost.R;
import com.example.foundnlost.databinding.FragmentTestBinding;
import com.example.foundnlost.util.ValidationUtil;
import com.google.android.material.textfield.TextInputLayout;

public class TestFragment extends Fragment {

    private FragmentTestBinding binding;


    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentTestBinding.inflate(inflater, container, false);
        View view = binding.getRoot();
        PhoneNumberFormattingTextWatcher phoneNumberWatcher = new PhoneNumberFormattingTextWatcher("PL");
        binding.phoneNumberInputLayout.getEditText().addTextChangedListener(phoneNumberWatcher);
        binding.nameInputLayout.getEditText().setFilters(new InputFilter[]{ValidationUtil.getWhitespaceFilter()});
        binding.button.setOnClickListener(v -> {
            validateVulgarities();
            validatePhoneNumber();
            validateEmail();
            validateName();
            validatePassword();
        });
        return view;
    }


    private boolean validateEmail() {
        if (!ValidationUtil.isEmailValid(binding.emailInputLayout.getEditText().getText().toString())) {
            binding.emailInputLayout.setError(getString(R.string.invalid_email_format));
            return false;
        }
        binding.emailInputLayout.setError(null);
        return true;

    }

    private boolean validatePassword() {
        if (!ValidationUtil.isPasswordValid(binding.passwordInputLayout.getEditText().getText().toString())) {
            binding.passwordInputLayout.setError(getString(R.string.password_weak));
            return false;
        }
        binding.passwordInputLayout.setError(null);
        return true;
    }

    private boolean validateName() {
        if (binding.nameInputLayout.getEditText().getText().toString().isEmpty()) {
            binding.nameInputLayout.setError(getString(R.string.field_cannot_be_empty));
            return false;
        }
        binding.nameInputLayout.setError(null);
        return true;
    }

    private String extractText(TextInputLayout textInputLayout) {
        if (textInputLayout.getEditText() != null) {
            return textInputLayout.getEditText().getText().toString();
        }
        return "";
    }

    private boolean validateVulgarities() {
        String rawText = extractText(binding.vulgaritiesInputLayout);
        String[] list = getResources().getStringArray(R.array.vulgarities);
        for (String s : list) {
            if (rawText.contains(s)) {
                binding.vulgaritiesInputLayout.setError(getString(R.string.vulgar_error));
                return false;
            }
        }
        binding.vulgaritiesInputLayout.setError(null);
        return true;
    }

    private boolean validatePhoneNumber() {
        if (extractText(binding.phoneNumberInputLayout).replaceAll("\\s", "").length() < 7) {
            binding.phoneNumberInputLayout.setError(getString(R.string.phone_number_too_short));
            return false;
        }
        binding.phoneNumberInputLayout.setError(null);
        return true;
    }

}