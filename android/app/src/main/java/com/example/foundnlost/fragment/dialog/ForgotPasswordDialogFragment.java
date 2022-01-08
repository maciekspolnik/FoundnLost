package com.example.foundnlost.fragment.dialog;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.DialogFragment;

import com.example.foundnlost.databinding.DialogForgotPasswordBinding;

public class ForgotPasswordDialogFragment extends DialogFragment {

    DialogForgotPasswordBinding binder;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binder = DialogForgotPasswordBinding.inflate(inflater, container, false);

        setCancelable(true);
        return binder.getRoot();
    }
}