package com.example.customlistwithnavigation;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.MenuItem;

import com.example.customlistwithnavigation.fragments.AdvancedJsonFragment;
import com.example.customlistwithnavigation.fragments.HomeFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

public class MainActivity extends AppCompatActivity {


    BottomNavigationView navigationView;

    public static String url = "https://sinka.lv/android_end_work.html";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        navigationView = findViewById(R.id.navigation_view);
        navigationView.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                if(item.isChecked()) {
                    return false;
                }

                switch (item.getItemId()) {
                    case R.id.nav_home: {
                        startHomeFragment();
                        return true;
                    }
                    case R.id.nav_wallpaper: {
                        startWallpaperFragment();
                        return true;
                    }
                    case R.id.nav_json_homework: {
                        startJsonHomeWorkFragment();
                        return true;
                    }
                    case R.id.nav_json_advanced: {
                        startAdvancedJsonHomeWorkFragment();
                        return true;
                    }
                    case R.id.nav_lucky_choise: {
                        startLuckyChoiceFragment();
                        return true;
                    }
                }
                return false;

            }
        });

        startHomeFragment();
        navigationView.getMenu().getItem(0).setChecked(true);
    }
    private void startFragment(Fragment fragment) {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.setCustomAnimations(R.anim.enter, R.anim.exit, R.anim.pop_enter, R.anim.pop_exit);
        transaction.replace(R.id.fragment_container, fragment);
        transaction.commit();
    }

    private void startWallpaperFragment() {
    }

    private void startJsonHomeWorkFragment() {
    }

    private void startAdvancedJsonHomeWorkFragment() {
        startFragment(new AdvancedJsonFragment());
    }

    private void startLuckyChoiceFragment() {
    }

    private void startHomeFragment() {
        startFragment(new HomeFragment());
    }
}