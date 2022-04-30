package com.example.foundnlost.ui.fragment;

import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.foundnlost.R;
import com.example.foundnlost.databinding.ManageAdvertsFragmentBinding;

public class ManageAdvertsFragment extends Fragment {

    private ManageAdvertsViewModel viewModel;
    private ManageAdvertsFragmentBinding binding;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        viewModel = new ViewModelProvider(this).get(ManageAdvertsViewModel.class);
        binding = ManageAdvertsFragmentBinding.inflate(inflater, container, false);

        return inflater.inflate(R.layout.manage_adverts_fragment, container, false);
    }


}