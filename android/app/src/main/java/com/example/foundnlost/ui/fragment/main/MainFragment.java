package com.example.foundnlost.ui.fragment.main;

import android.content.res.ColorStateList;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.example.foundnlost.R;
import com.example.foundnlost.commons.AdvertType;
import com.example.foundnlost.data.network.model.Advert;
import com.example.foundnlost.databinding.FragmentAdvertsBinding;
import com.example.foundnlost.ui.adapter.AdvertsAdapter;
import com.example.foundnlost.ui.fragment.dialog.ContactInfoDialog;
import com.example.foundnlost.viewModel.MainViewModel;
import com.example.foundnlost.viewModel.factory.ViewModelFactory;

import java.util.ArrayList;

public class MainFragment extends Fragment {

    private MainViewModel viewModel;
    private FragmentAdvertsBinding binding;
    private AdvertType currentIndicator;
    private AdvertsAdapter adapter;
    private ArrayList<Advert> list = new ArrayList<>();

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        binding = FragmentAdvertsBinding.inflate(inflater, container, false);
        viewModel = new ViewModelProvider(this, new ViewModelFactory(requireContext())).get(MainViewModel.class);
        binding.mainRecyclerView.setLayoutManager(new LinearLayoutManager(requireContext()));
        adapter = new AdvertsAdapter(
                list,
                requireContext(),
                view -> new ContactInfoDialog().show(requireActivity().getSupportFragmentManager(), ""));
        adapter.setDrawable(R.drawable.icon_goback);
        binding.mainRecyclerView.setAdapter(adapter);
        binding.lostIndicator.setOnClickListener(view -> changeTab(AdvertType.LOST));
        binding.foundIndicator.setOnClickListener(view -> changeTab(AdvertType.FOUND));
        changeTab(AdvertType.FOUND);

        return binding.getRoot();
    }

    private void changeTab(AdvertType indicator) {
        if (indicator == currentIndicator) {
            return;
        }
        list = indicator == AdvertType.FOUND ? viewModel.getFoundAdverts() : viewModel.getLostAdverts();
        adapter.updateData(indicator == AdvertType.FOUND ? viewModel.getFoundAdverts() : viewModel.getLostAdverts());
        adjustButton(binding.foundIndicator, indicator == AdvertType.FOUND);
        adjustButton(binding.lostIndicator, indicator == AdvertType.LOST);
        currentIndicator = indicator;
    }

    private void adjustButton(Button button, boolean clicked) {
        button.setClickable(!clicked);
        button.setElevation(clicked ? 4f : 0f);
        button.setBackgroundTintList(ColorStateList.valueOf(ContextCompat.getColor(requireContext(), clicked ? R.color.french_rose : R.color.black10)));
    }
}