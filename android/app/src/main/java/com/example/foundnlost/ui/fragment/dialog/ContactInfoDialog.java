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

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        Bundle bundle = getArguments();
        binding = DialogContactInfoBinding.inflate(inflater, container, false);

        binding.emailTextView.setText(bundle != null ? bundle.getString("email") : Const.EMPTY_STRING);
        binding.button.setOnClickListener(view -> callPhoneNumber(bundle != null ? bundle.getString("phoneNumber", Const.EMPTY_STRING) : null));

        return binding.getRoot();
    }

    private void callPhoneNumber(String phone) {
        Intent callIntent = new Intent(Intent.ACTION_DIAL);
        callIntent.setData(Uri.parse(Const.DIALING_PREFIX + phone));
        startActivity(callIntent);
    }

}