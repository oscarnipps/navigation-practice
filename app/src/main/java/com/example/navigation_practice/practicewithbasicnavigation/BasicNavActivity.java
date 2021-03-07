package com.example.navigation_practice.practicewithbasicnavigation;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.navigation.NavController;
import androidx.navigation.fragment.NavHostFragment;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.example.navigation_practice.R;
import com.example.navigation_practice.databinding.ActivityBasicNavBinding;
import com.google.android.material.navigation.NavigationView;

import java.util.HashSet;
import java.util.Set;

public class BasicNavActivity extends AppCompatActivity   {

    private ActivityBasicNavBinding binding;
    private NavController navController;
    private DrawerLayout drawerLayout;
    private NavigationView navigationView;
    private AppBarConfiguration appBarConfiguration;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_basic_nav);

        setSupportActionBar(binding.toolbar);

        drawerLayout = binding.drawerLayout;

        navigationView = binding.navigationView;

        NavHostFragment navHostFragment = (NavHostFragment) getSupportFragmentManager().findFragmentById(R.id.navigation_host_container);

        navController = navHostFragment.getNavController();

        NavigationUI.setupWithNavController(navigationView, navController);

        Set<Integer> topLevelDestinations = new HashSet<>();
        topLevelDestinations.add(R.id.first_fragment);
        topLevelDestinations.add(R.id.second_fragment);

        appBarConfiguration = new AppBarConfiguration.Builder(topLevelDestinations)
                .setOpenableLayout(drawerLayout)
                .build();

        NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration);

        NavigationUI.setupWithNavController(binding.toolbar, navController,drawerLayout);
    }

}