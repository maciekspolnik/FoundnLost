package com.example.foundnlost.fragment;

import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.foundnlost.databinding.FragmentMyPostsBinding;
import com.example.foundnlost.viewModel.MyPostsViewModel;

public class MyPostsFragment extends Fragment {

    private MyPostsViewModel viewModel;
    private FragmentMyPostsBinding binder;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        binder = FragmentMyPostsBinding.inflate(inflater,container,false);
        viewModel = new ViewModelProvider(this).get(MyPostsViewModel.class);
        return binder.getRoot();
    }

}