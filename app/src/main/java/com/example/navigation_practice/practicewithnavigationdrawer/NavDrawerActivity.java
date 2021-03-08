package com.example.navigation_practice.practicewithnavigationdrawer;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.navigation.NavController;
import androidx.navigation.fragment.NavHostFragment;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.example.navigation_practice.R;
import com.example.navigation_practice.databinding.ActivityNavDrawerBinding;
import com.google.android.material.navigation.NavigationView;

import java.util.HashSet;
import java.util.Set;

public class NavDrawerActivity extends AppCompatActivity {

    public static final String TAG = NavDrawerActivity.class.getSimpleName();
    private ActivityNavDrawerBinding binding;
    private NavController navController;
    private DrawerLayout drawerLayout;
    private NavigationView navigationView;
    private AppBarConfiguration appBarConfiguration;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_nav_drawer);

        drawerLayout = binding.drawerLayout;

        navigationView = binding.navigationView;

        setSupportActionBar(binding.toolbar);

        NavHostFragment navHostFragment = (NavHostFragment) getSupportFragmentManager().findFragmentById(R.id.host_container);

        navController = navHostFragment.getNavController();

        NavigationUI.setupWithNavController(navigationView, navController);

        Set<Integer> topLevelDestinations = new HashSet<>();

        topLevelDestinations.add(R.id.profileFragment);

        topLevelDestinations.add(R.id.historyFragment);

        topLevelDestinations.add(R.id.settingsFragment);

        appBarConfiguration = new AppBarConfiguration.Builder(topLevelDestinations)
                .setOpenableLayout(drawerLayout)
                .build();

        NavigationUI.setupActionBarWithNavController(this, navController, drawerLayout);
    }

    @Override
    public boolean onSupportNavigateUp() {
        return NavigationUI.navigateUp(navController, appBarConfiguration) || super.onSupportNavigateUp();
    }
}