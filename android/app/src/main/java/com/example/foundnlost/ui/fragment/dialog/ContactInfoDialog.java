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
import androidx.lifecycle.ViewModelProvider;

import com.example.foundnlost.databinding.DialogContactInfoBinding;
import com.example.foundnlost.viewModel.ContactInfoDialogViewModel;
import com.example.foundnlost.viewModel.factory.ViewModelFactory;

public class ContactInfoDialog extends DialogFragment {

    private ContactInfoDialogViewModel viewModel;
    private DialogContactInfoBinding binding;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        viewModel = new ViewModelProvider(this,new ViewModelFactory(requireContext())).get(ContactInfoDialogViewModel.class);

        binding = DialogContactInfoBinding.inflate(inflater,container,false);

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