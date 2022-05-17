package com.example.foundnlost.ui.fragment.main;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.example.foundnlost.R;
import com.example.foundnlost.data.network.dto.AdvertDto;
import com.example.foundnlost.data.network.dto.ContactDataDto;
import com.example.foundnlost.data.network.dto.Resource;
import com.example.foundnlost.databinding.FragmentAdvertsBinding;
import com.example.foundnlost.ui.adapter.AdvertsAdapter;
import com.example.foundnlost.ui.fragment.dialog.ContactInfoDialog;
import com.example.foundnlost.viewModel.MainViewModel;
import com.example.foundnlost.viewModel.factory.ViewModelFactory;

import java.util.ArrayList;
import java.util.List;

public class AdvertsFragment extends Fragment {

    private MainViewModel viewModel;
    private FragmentAdvertsBinding binding;
    private AdvertsAdapter adapter;
    private ArrayList<AdvertDto> list = new ArrayList<>();

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        binding = FragmentAdvertsBinding.inflate(inflater, container, false);
        viewModel = new ViewModelProvider(this, new ViewModelFactory(requireContext())).get(MainViewModel.class);
        binding.mainRecyclerView.setLayoutManager(new LinearLayoutManager(requireContext()));
        adapter = new AdvertsAdapter(
                list,
                requireContext(),
                view -> viewModel.getContactData(adapter.getClickedData()).observe(getViewLifecycleOwner(), this::consumeDataResponse));
        adapter.setDrawable(R.drawable.icon_goback);
        binding.mainRecyclerView.setAdapter(adapter);
        loadAdverts();

        return binding.getRoot();
    }

    private void consumeDataResponse(Resource<ContactDataDto> response) {
        ContactInfoDialog dialog = new ContactInfoDialog();
        Bundle arguments = new Bundle();
        arguments.putString("email",response.getResult().getEmail());
        arguments.putString("phoneNumber",response.getResult().getPhoneNumber());
        dialog.setArguments(arguments);
        dialog.show(requireActivity().getSupportFragmentManager(), "");
    }


    private void loadAdverts() {
        viewModel.getAdvertData().observe(getViewLifecycleOwner(), this::consumeResponse);
    }

    private void consumeResponse(List<AdvertDto> listResponse) {
        if (listResponse == null || listResponse.isEmpty()) {
            return;
        }
        adapter.updateData(listResponse);
    }
}