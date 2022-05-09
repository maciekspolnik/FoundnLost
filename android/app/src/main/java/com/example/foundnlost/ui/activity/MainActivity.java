package com.example.foundnlost.ui.activity;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;

import com.example.foundnlost.R;
import com.example.foundnlost.databinding.ActivityMainBinding;
import com.example.foundnlost.ui.fragment.FlowFragment;
import com.example.foundnlost.ui.fragment.main.AdvertsFragment;
import com.example.foundnlost.ui.fragment.main.ManageAdvertsFragment;
import com.example.foundnlost.ui.fragment.main.ProfileFragment;
import com.google.android.material.bottomnavigation.BottomNavigationItemView;
import com.google.android.material.bottomnavigation.BottomNavigationMenuView;
import com.google.android.material.navigation.NavigationBarView;

import java.util.ArrayList;
import java.util.List;

import timber.log.Timber;

public class MainActivity extends AppCompatActivity implements FlowFragment.OnFragmentChangeRequest {

    private ActivityMainBinding binding;
    private final List<View> indicatorViews = new ArrayList<>();
    private int currentFragmentId;

    private int HOME_ID = 0;
    private int MANAGE_ID = 1;
    private int PROFILE_ID = 2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.navigation.setOnItemSelectedListener(navigationListener);
        displayFragment(new AdvertsFragment());
        currentFragmentId = HOME_ID;
        BottomNavigationMenuView menuView = (BottomNavigationMenuView) binding.navigation.getChildAt(0);
        binding.navigation
                .getMenu()
                .getItem(currentFragmentId)
                .setChecked(true);
        setupIndicators(menuView);
        enableIndicatorForItem(currentFragmentId);
        addFragmentOnAttachListener();


    }

    public void displayFragment(Fragment fragment) {
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.main_fragment_container, fragment, null)
                .addToBackStack(null)
                .commit();
    }

    public void showDialog(DialogFragment dialog) {
        dialog.show(getSupportFragmentManager(), null);
    }

    private void enableIndicatorForItem(int position) {
        for (View view : indicatorViews) {
            view.setVisibility(View.GONE);
        }
        indicatorViews.get(position).setVisibility(View.VISIBLE);
    }

    private void addFragmentOnAttachListener() {
        getSupportFragmentManager().addFragmentOnAttachListener((fragmentManager, fragment) -> {
            Timber.d("Attaching fragment");
            if (fragment instanceof FlowFragment) {
                FlowFragment flowFragment = (FlowFragment) fragment;
                flowFragment.setOnFragmentChangeRequestListener(this);
            }
        });
    }
    @Override
    public void onFragmentChangeRequest(Fragment fragment) {
        if(fragment instanceof DialogFragment){
            ((DialogFragment) fragment).show(getSupportFragmentManager(), null);
        }
        displayFragment(fragment);
    }

    private void setupIndicators(BottomNavigationMenuView menuView) {
        for (int i = 0; i < menuView.getChildCount(); i++) {
            BottomNavigationItemView vx = (BottomNavigationItemView) menuView.getChildAt(i);
            View indicatorLayout = LayoutInflater.from(this).inflate(R.layout.indicator_layout, vx, true);
            ImageView indicatorView = indicatorLayout.findViewById(R.id.cardLocationIcon);
            indicatorView.setVisibility(View.GONE);
            indicatorViews.add(indicatorView);
        }
    }

    private final NavigationBarView.OnItemSelectedListener navigationListener = item -> {
        enableIndicatorForItem(item.getOrder());
        switch (item.getItemId()) {
            case R.id.nav_home:
                if (currentFragmentId != HOME_ID) {
                    displayFragment(new AdvertsFragment());
                    currentFragmentId = HOME_ID;
                }
                return true;

            case R.id.nav_manage:
                if (currentFragmentId != MANAGE_ID) {
                    displayFragment(new ManageAdvertsFragment());
                    currentFragmentId = MANAGE_ID;
                }
                return true;

            case R.id.nav_profile:
                if (currentFragmentId != PROFILE_ID) {
                    displayFragment(new ProfileFragment());
                    currentFragmentId = PROFILE_ID;
                }
                return true;
        }
        return false;
    };
}