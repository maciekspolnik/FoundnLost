package com.example.foundnlost;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        displayFragment(new RegisterFragment());
    }

    public void displayFragment(Fragment fragment){
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.fragment_container_view,fragment,null)
                .disallowAddToBackStack()
                .commit();
    }

    public void showDialog(DialogFragment dialog) {
        dialog.show(getSupportFragmentManager(), "YourDialog");
    }

}