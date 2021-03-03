package com.example.navigation_practice;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.example.navigation_practice.practicewithbottomnavigationview.BottomNavActivity;
import com.example.navigation_practice.practicewithnavigationdrawer.NavDrawerActivity;
import com.example.navigation_practice.practicewithviewpager2.ViewPagerActivity;

public class EntryActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_entry);
    }

    public void openNavigationDrawerDemo(View view) {
        Intent intent = new Intent(this, NavDrawerActivity.class);
        startActivity(intent);
    }

    public void openBottomNavigationViewDemo(View view) {
        Intent intent = new Intent(this, BottomNavActivity.class);
        startActivity(intent);
    }

    public void openViewPagerDemo(View view) {
        Intent intent = new Intent(this, ViewPagerActivity.class);
        startActivity(intent);
    }
}