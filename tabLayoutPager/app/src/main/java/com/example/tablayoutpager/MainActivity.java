package com.example.tablayoutpager;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.example.tablayoutpager.adapter.MypagerAdapter;
import com.google.android.material.tabs.TabLayout;

/**
 * Pager : 종이 넘기듯이 화면을 넘겨주는 역할을 하는 오브젝트
 * - Adapter
 * <p>
 * Tablayout : 탭을 담당하는 역할
 * - 보통 같이 작성을 하지만 따로 따로 만들어도 상관이 없다.
 * <p>
 * LIstener
 * - Pager와 Tablayout 을 연결해 주기 위해서 필요하다.
 */

public class MainActivity extends AppCompatActivity {

    private static final String TAG = MainActivity.class.getName();
    public static final int TABCOUNT = 3;
    ViewPager viewPager;
    TabLayout tabLayout;

    private void initData() {
        viewPager = findViewById(R.id.myViewPager);
        tabLayout = findViewById(R.id.tabLayout);
        tabLayout.addTab(tabLayout.newTab().setText("ONE"));
        tabLayout.addTab(tabLayout.newTab().setText("TWO"));
        tabLayout.addTab(tabLayout.newTab().setText("THREE"));
        MypagerAdapter myPager = new MypagerAdapter(getSupportFragmentManager(), TABCOUNT);
        viewPager.setAdapter(myPager);

    }

    private void addEventListner() {
        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                int tabPage = tab.getPosition() ;
                viewPager.setCurrentItem(tabPage);
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {
                int tabPage = tab.getPosition() ;
            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {
                int tabPage = tab.getPosition() ;
            }
        });


    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initData();
        addEventListner();
    }


}
