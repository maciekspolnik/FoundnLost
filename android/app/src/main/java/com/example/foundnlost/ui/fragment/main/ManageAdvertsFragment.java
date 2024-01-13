package com.example.foundnlost.ui.fragment.main;

import android.app.AlertDialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.example.foundnlost.R;
import com.example.foundnlost.data.network.dto.AdvertDto;
import com.example.foundnlost.databinding.FragmentManageAdvertsBinding;
import com.example.foundnlost.ui.adapter.AdvertsAdapter;
import com.example.foundnlost.ui.fragment.FlowFragment;
import com.example.foundnlost.viewModel.ManageAdvertsViewModel;
import com.example.foundnlost.viewModel.factory.ViewModelFactory;

import java.util.ArrayList;

public class ManageAdvertsFragment extends FlowFragment {

    private ManageAdvertsViewModel viewModel;
    private FragmentManageAdvertsBinding binding;
    private AdvertsAdapter adapter;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        viewModel = new ViewModelProvider(this, new ViewModelFactory(requireContext())).get(ManageAdvertsViewModel.class);
        binding = FragmentManageAdvertsBinding.inflate(inflater, container, false);
        binding.myAdvertsRecyclerView.setLayoutManager(new LinearLayoutManager(requireContext()));
        viewModel.getAdvertData().observe(getViewLifecycleOwner(), this::consumeResponse);

        setCloseButtonClickAction();

        return binding.getRoot();
    }

    private void consumeResponse(ArrayList<AdvertDto> advertDtos) {
        adapter = new AdvertsAdapter(
                advertDtos,
                requireContext(),
                view -> showConfirmationAlert());
        adapter.setDrawable(R.drawable.icon_close);
        binding.myAdvertsRecyclerView.setAdapter(adapter);
    }

    private void showConfirmationAlert() {
        new AlertDialog.Builder(requireContext())
                .setMessage(getString(R.string.delete_advert_confirm))
                .setPositiveButton(getString(R.string.confirm), (dialog, arg) -> viewModel.deleteAdvert(adapter.getClickedData()))
                .setNegativeButton(getString(R.string.cancel), null)
                .show();
    }

    private void setCloseButtonClickAction() {
        binding.advertsButton.setOnClickListener(view -> onFragmentChangeRequestListener.onFragmentChangeRequest(new AddAdvertFragment()));
    }


}