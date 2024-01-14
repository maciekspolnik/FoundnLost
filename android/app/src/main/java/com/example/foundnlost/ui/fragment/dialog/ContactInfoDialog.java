package com.example.foundnlost.ui.fragment.dialog;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;

import com.example.foundnlost.databinding.DialogContactInfoBinding;
import com.example.foundnlost.util.Const;

public class ContactInfoDialog extends DialogFragment {
    private DialogContactInfoBinding binding;
    private String email;
    private String phoneNumber;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        Bundle bundle = getArguments();
        binding = DialogContactInfoBinding.inflate(inflater, container, false);
        if (bundle != null) {
            email = bundle.getString("email");
            phoneNumber = bundle.getString("phoneNumber", Const.EMPTY_STRING);
        }
        binding.button.setOnClickListener(view -> callPhoneNumber(phoneNumber));
        binding.button2.setOnClickListener(view -> openMailApp(email));
        return binding.getRoot();
    }

    private void callPhoneNumber(String phone) {
        if (phone == null) {
            return;
        }
        Intent callIntent = new Intent(Intent.ACTION_DIAL);
        callIntent.setData(Uri.parse(Const.DIALING_PREFIX + phone));
        startActivity(callIntent);
    }

    private void openMailApp(String email) {
        if (email == null) {
            return;
        }
        Intent intent = new Intent(Intent.ACTION_SENDTO);
        intent.setData(Uri.parse("mailto:"));
        intent.putExtra(Intent.EXTRA_EMAIL, email);
        this.startActivity(intent);
    }

}