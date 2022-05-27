package com.example.tablayoutpager.adapter;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.fragment.app.FragmentStatePagerAdapter;

import com.example.tablayoutpager.Fragment1;
import com.example.tablayoutpager.Fragment2;
import com.example.tablayoutpager.Fragment3;
import com.example.tablayoutpager.MainActivity;

public class MypagerAdapter extends FragmentStatePagerAdapter {


        public MypagerAdapter(@NonNull FragmentManager fm, int behavior) {
            super(fm, behavior);
        }

        @NonNull
        @Override
        public Fragment getItem(int position) {
            Fragment fragment = null;
            switch (position){
                case 0:
                    fragment = new Fragment1();
                    break;
                case 1:
                    fragment = new Fragment2();
                    break;
                case 2:
                    fragment = new Fragment3();
                    break;
            }
            return fragment;
        }

        @Override
        public int getCount() {
            return MainActivity.TABCOUNT;
        }

}
