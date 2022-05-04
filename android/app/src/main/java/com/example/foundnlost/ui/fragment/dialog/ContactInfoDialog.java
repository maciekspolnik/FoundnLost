package com.example.foundnlost.ui.fragment.dialog;

import androidx.fragment.app.DialogFragment;
import androidx.lifecycle.ViewModelProvider;

import android.app.Dialog;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.foundnlost.databinding.ContactInfoDialogBinding;
import com.example.foundnlost.viewModel.ContactInfoDialogViewModel;
import com.example.foundnlost.viewModel.factory.ViewModelFactory;

public class ContactInfoDialog extends DialogFragment {

    private ContactInfoDialogViewModel viewModel;
    private ContactInfoDialogBinding binding;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        viewModel = new ViewModelProvider(this,new ViewModelFactory(requireContext())).get(ContactInfoDialogViewModel.class);

        binding = ContactInfoDialogBinding.inflate(inflater,container,false);

        binding.button.setOnClickListener(view->{
            callPhoneNumber();
        });

        return binding.getRoot();
    }

    private void callPhoneNumber() {
        String phone = "535085225";
        Intent callIntent = new Intent(Intent.ACTION_DIAL);
        callIntent.setData(Uri.parse("tel:" + phone));
        startActivity(callIntent);
    }

}