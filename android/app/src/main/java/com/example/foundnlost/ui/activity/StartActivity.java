package com.example.foundnlost.ui.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.View;

import com.example.foundnlost.databinding.ActivityStartBinding;
import com.example.foundnlost.R;
import com.example.foundnlost.ui.fragment.FlowFragment;
import com.example.foundnlost.ui.fragment.start.StartFragment;

import timber.log.Timber;

public class StartActivity extends AppCompatActivity implements FlowFragment.OnFragmentChangeRequest {

    ActivityStartBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityStartBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);
        addFragmentOnAttachListener();

        displayFragment(new StartFragment());
    }

    public void displayFragment(Fragment fragment){
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.fragment_container_view,fragment,null)
                .addToBackStack(null)
                .commit();
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
        displayFragment(fragment);
    }

    public void showDialog(DialogFragment dialog) {
        dialog.show(getSupportFragmentManager(), null);
    }

}