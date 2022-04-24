package com.example.foundnlost.ui.fragment;

import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;
import androidx.core.content.res.ResourcesCompat;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.lifecycle.ViewModelProvider;

import android.content.res.ColorStateList;
import android.graphics.drawable.Drawable;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.foundnlost.R;
import com.example.foundnlost.databinding.FragmentAdvertsBinding;
import com.example.foundnlost.util.Const;
import com.example.foundnlost.viewModel.FoundViewModel;

public class FoundFragment extends Fragment {

    private FoundViewModel viewModel;
    private FragmentAdvertsBinding binding;
    private Indicator currentIndicator;


    private enum Indicator {LOST_INDICATOR, FOUND_INDICATOR}

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        binding = FragmentAdvertsBinding.inflate(inflater, container, false);
        viewModel = new ViewModelProvider(this).get(FoundViewModel.class);

        binding.lostIndicator.setOnClickListener(view -> changeTab(Indicator.LOST_INDICATOR));
        binding.foundIndicator.setOnClickListener(view -> changeTab(Indicator.FOUND_INDICATOR));
        changeTab(Indicator.FOUND_INDICATOR);

        return binding.getRoot();
    }


    private void changeTab(Indicator indicator) {
        if (indicator == currentIndicator) {
            return;
        }
        adjustButton(binding.foundIndicator, indicator == Indicator.FOUND_INDICATOR);
        adjustButton(binding.lostIndicator, indicator == Indicator.LOST_INDICATOR);
        currentIndicator = indicator;
    }

    private void adjustButton(Button button, boolean clicked) {
        button.setClickable(!clicked);
        button.setBackgroundTintList(ColorStateList.valueOf(ContextCompat.getColor(requireContext(), clicked ? R.color.accentPink : R.color.white)));
    }
}