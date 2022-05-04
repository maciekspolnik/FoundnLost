package com.example.foundnlost.ui.fragment.dialog;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.DialogFragment;

import com.example.foundnlost.databinding.DialogForgotPasswordBinding;

public class ForgotPasswordDialog extends DialogFragment {

    DialogForgotPasswordBinding binding;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        binding = DialogForgotPasswordBinding.inflate(inflater, container, false);
        binding.imageButton.setOnClickListener(view -> dismiss());
        setCancelable(true);
        return binding.getRoot();
    }
}