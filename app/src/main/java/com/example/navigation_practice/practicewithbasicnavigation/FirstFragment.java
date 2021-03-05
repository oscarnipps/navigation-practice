package com.example.navigation_practice.practicewithbasicnavigation;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import com.example.navigation_practice.R;
import com.example.navigation_practice.databinding.FragmentFirstBinding;

public class FirstFragment extends Fragment {

    private FragmentFirstBinding binding;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(inflater,R.layout.fragment_first,container,false);

       FirstFragmentDirections.NavigateToSecondFragment actions = FirstFragmentDirections.navigateToSecondFragment();

        actions.setUser(getUser());

        binding.firstFragment.setOnClickListener(v -> Navigation.findNavController(binding.getRoot()).navigate(actions));

        return binding.getRoot();
    }

    private User getUser() {
        return new User("david blake johnson" ,8);
    }
}