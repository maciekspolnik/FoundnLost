package com.example.foundnlost.ui.fragment.dialog;

import androidx.fragment.app.DialogFragment;
import androidx.lifecycle.ViewModelProvider;

import android.app.Dialog;
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
        return binding.getRoot();
    }
}