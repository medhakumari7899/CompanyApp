package com.example.companyapp.Activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.TextView;


import com.example.companyapp.Fragement.HomeFragement;
import com.example.companyapp.Fragement.PremiumFragment;
import com.example.companyapp.Fragement.ProfileFragment;
import com.example.companyapp.R;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener {

    BottomNavigationView navigationView;


    TextView textView;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        navigationView=findViewById(R.id.bottomnavigation);


        BottomNavigationView navigation = findViewById(R.id.bottomnavigation);
        navigation.setOnNavigationItemSelectedListener(this);
        loadFragment(new ProfileFragment());


    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        Fragment fragment = null;

        switch (item.getItemId()) {
            case R.id.navigation_home:
                fragment = new HomeFragement();
                break;

            case R.id.premium:
                fragment = new PremiumFragment();
                break;


            case R.id.profile:
                fragment = new ProfileFragment();
                break;
        }
        return loadFragment(fragment);

    }

    private boolean loadFragment(Fragment fragment) {
        if (fragment != null) {
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.dashboard_frame, fragment)
                    .commit();
            return true;
        }
        return false;
    }
}