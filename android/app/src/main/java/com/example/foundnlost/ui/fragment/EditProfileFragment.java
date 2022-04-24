package com.example.foundnlost.ui.fragment;

import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.foundnlost.databinding.FragmentEditProfileBinding;
import com.example.foundnlost.viewModel.EditProfileViewModel;

public class EditProfileFragment extends Fragment {

    private EditProfileViewModel viewModel;
    private FragmentEditProfileBinding binding;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        binding = FragmentEditProfileBinding.inflate(inflater, container, false);
        viewModel = new ViewModelProvider(this).get(EditProfileViewModel.class);
        return binding.getRoot();
    }

}