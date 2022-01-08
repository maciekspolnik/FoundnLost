package com.example.foundnlost.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.View;

import com.example.foundnlost.databinding.ActivityMainBinding;
import com.example.foundnlost.databinding.ActivityStartBinding;
import com.example.foundnlost.fragment.MainFragment;
import com.example.foundnlost.R;
import com.example.foundnlost.fragment.StartFragment;

public class StartActivity extends AppCompatActivity {

    ActivityStartBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityStartBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);
        displayFragment(new StartFragment());
    }

    public void displayFragment(Fragment fragment){
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.fragment_container_view,fragment,null)
                .addToBackStack(null)
                .commit();
    }

    public void showDialog(DialogFragment dialog) {
        dialog.show(getSupportFragmentManager(), null);
    }

}