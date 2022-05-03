package com.example.foundnlost.ui.fragment.main;

import androidx.lifecycle.ViewModelProvider;

import android.app.AlertDialog;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.foundnlost.databinding.ManageAdvertsFragmentBinding;
import com.example.foundnlost.ui.adapter.AdvertsAdapter;
import com.example.foundnlost.ui.fragment.FlowFragment;
import com.example.foundnlost.ui.fragment.dialog.ContactInfoDialog;
import com.example.foundnlost.ui.fragment.dialog.ForgotPasswordDialog;
import com.example.foundnlost.viewModel.ManageAdvertsViewModel;
import com.example.foundnlost.viewModel.factory.ViewModelFactory;

public class ManageAdvertsFragment extends FlowFragment {

    private ManageAdvertsViewModel viewModel;
    private ManageAdvertsFragmentBinding binding;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        viewModel = new ViewModelProvider(this, new ViewModelFactory(requireContext())).get(ManageAdvertsViewModel.class);
        binding = ManageAdvertsFragmentBinding.inflate(inflater, container, false);
        binding.myAdvertsRecyclerView.setLayoutManager(new LinearLayoutManager(requireContext()));
        binding.myAdvertsRecyclerView.setAdapter(new AdvertsAdapter(
                viewModel.getAdvertsDemo(),
                requireContext(),
                view -> new ContactInfoDialog().show(requireActivity().getSupportFragmentManager(), "")));
        setCloseButtonClickAction();

        return binding.getRoot();
    }

    private void setCloseButtonClickAction() {
        binding.advertsButton.setOnClickListener(view ->
                onFragmentChangeRequestListener.onFragmentChangeRequest(new AddAdvertFragment()));
    }


}