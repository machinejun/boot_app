package com.example.fragmentsample;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentContainerView;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;

import com.example.fragmentsample.Fragments.CarrotFragment;
import com.example.fragmentsample.Fragments.CheatFragment;
import com.example.fragmentsample.Fragments.DocumentFragment;
import com.example.fragmentsample.Fragments.HomeFragment;
import com.example.fragmentsample.Fragments.LocationFragment;
import com.example.fragmentsample.Fragments.OptionFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity implements OptionFragment.OptionEventListener{
    Fragment optionfragment;
    Fragment homeFragment;
    Fragment documentFragment;
    Fragment CheatFragment;
    Fragment locationFragment;
    FragmentContainerView containerView;
    BottomNavigationView bottomNavigationView;
    FragmentManager manager;





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initData();
        addEventListener();
    }

    private void initData(){
        Toolbar toolbar = findViewById(R.id.toolBar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("나의 당근");


        optionfragment = new OptionFragment();
        homeFragment = new HomeFragment();
        documentFragment = new DocumentFragment();
        CheatFragment = new CheatFragment();
        locationFragment= new LocationFragment();

        bottomNavigationView = findViewById(R.id.bottomNavigation);
        manager = getSupportFragmentManager();

        containerView = findViewById(R.id.container);
        FragmentTransaction transaction = manager.beginTransaction();
        transaction.replace(R.id.container, optionfragment);
        transaction.commit();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.tool_bar, menu);
        return true;
    }


    private void addEventListener(){


        bottomNavigationView.setOnItemSelectedListener(item -> {
            FragmentTransaction transaction = manager.beginTransaction();
            switch (item.getItemId()){
                case R.id.homeIcon:
                    transaction.replace(R.id.container, homeFragment);
                    break;
                case R.id.document:
                    transaction.replace(R.id.container, documentFragment);
                    break;
                case R.id.location:
                    transaction.replace(R.id.container, locationFragment);
                    break;
                case R.id.cheat:
                    transaction.replace(R.id.container, CheatFragment);
                    break;
                case R.id.myCarrot:
                    transaction.replace(R.id.container, optionfragment);
            }
            transaction.commit();
            return true;
        });
    }


    @Override
    public void optionCilck(int id) {
        Intent intent = new Intent(this, ProfileActivity.class);
        startActivity(intent);
    }
}