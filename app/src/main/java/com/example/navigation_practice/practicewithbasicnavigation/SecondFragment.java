package com.example.navigation_practice.practicewithbasicnavigation;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import com.example.navigation_practice.R;
import com.example.navigation_practice.databinding.FragmentSecondBinding;

public class SecondFragment extends Fragment {

    private FragmentSecondBinding binding;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(inflater,R.layout.fragment_second,container,false);

        binding.secondFragment.setOnClickListener(v -> Navigation.findNavController(binding.getRoot()).navigate(R.id.navigateToFirstFragment));

        return binding.getRoot();
    }
}