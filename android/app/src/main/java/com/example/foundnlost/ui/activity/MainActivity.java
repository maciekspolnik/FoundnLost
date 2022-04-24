package com.example.foundnlost.ui.activity;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;

import com.example.foundnlost.R;
import com.example.foundnlost.databinding.ActivityMainBinding;
import com.example.foundnlost.ui.fragment.FoundFragment;
import com.example.foundnlost.ui.fragment.LostFragment;
import com.example.foundnlost.ui.fragment.MainFragment;
import com.example.foundnlost.ui.fragment.ProfileFragment;
import com.google.android.material.bottomnavigation.BottomNavigationItemView;
import com.google.android.material.bottomnavigation.BottomNavigationMenuView;
import com.google.android.material.navigation.NavigationBarView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;
    private final List<View> indicatorViews = new ArrayList<>();
    private int currentFragmentId;

    private int HOME_ID = 0;
    private int FOUND_ID = 1;
    private int LOST_ID = 2;
    private int PROFILE_ID = 3;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);
        binding.navigation.setOnItemSelectedListener(navigationListener);
        displayFragment(new MainFragment());
        currentFragmentId = HOME_ID;
        BottomNavigationMenuView menuView = (BottomNavigationMenuView) binding.navigation.getChildAt(0);
        binding.navigation.getMenu().getItem(currentFragmentId).setChecked(true);
        setupIndicators(menuView);
        enableIndicatorForItem(currentFragmentId);


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
                    displayFragment(new MainFragment());
                    currentFragmentId = HOME_ID;
                }
                return true;

            case R.id.nav_found:
                if (currentFragmentId != FOUND_ID) {
                    displayFragment(new FoundFragment());
                    currentFragmentId = FOUND_ID;
                }
                return true;

            case R.id.nav_lost:
                if (currentFragmentId != LOST_ID) {
                    displayFragment(new LostFragment());
                    currentFragmentId = LOST_ID;
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