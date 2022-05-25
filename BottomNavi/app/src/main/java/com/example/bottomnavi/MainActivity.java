package com.example.bottomnavi;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;

import com.example.bottomnavi.utils.FragmentType;
import com.google.android.material.bottomnavigation.BottomNavigationItemView;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

public class MainActivity extends AppCompatActivity {
    private BottomNavigationView bottomNavigation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        bottomNavigation = findViewById(R.id.bottomNavigation);
        addBottomNavigationListner();



    }
    private void addBottomNavigationListner() {
        bottomNavigation.setOnItemSelectedListener(item -> {
            switch (item.getItemId()) {
                case R.id.page_home:
                    Log.d("TAG", "home");
                    replaceFragment(FragmentType.HOME);
                    break;
                case R.id.page_tv:
                    Log.d("TAG", "tv");
                    replaceFragment(FragmentType.TV);
                    break;
                case R.id.page_bike:
                    replaceFragment(FragmentType.BIKE);
                    Log.d("TAG", "bike");
            }
            return true;
        });
    }

    private void replaceFragment(FragmentType type){
        //fragment
        Fragment fragment;
        FragmentManager manager = getSupportFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();

        if(type == FragmentType.HOME){
            fragment = new Fragment_home();
        }else if(type == FragmentType.TV){
            fragment = new Fragment_tv();
        }else {
            fragment = new Fragment_Bike();
        }
        transaction.replace(R.id.fragmentContainer, fragment);
        transaction.commit();

    }




}