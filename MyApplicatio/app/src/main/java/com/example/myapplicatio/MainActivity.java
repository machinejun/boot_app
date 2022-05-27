package com.example.myapplicatio;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.Lifecycle;
import androidx.viewpager2.adapter.FragmentStateAdapter;
import androidx.viewpager2.widget.ViewPager2;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.example.myapplicatio.Adapter.ImageSliderAdapter;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ViewPager2 sliderImageViewPager;
    private ArrayList<String> images = new ArrayList<String>();
    TabLayout tabLayout;
    private LinearLayout layoutIndicatorsContainer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initData();
        addEvnetLisnter();
        setupIndicators(images.size());
    }

    private void initData() {
        images.add("https://cdn.pixabay.com/photo/2022/05/10/06/34/baby-photoshoot-7186087__340.jpg");
        images.add("https://cdn.pixabay.com/photo/2022/04/11/10/09/apricot-blossoms-7125429__340.jpg");
        images.add("https://cdn.pixabay.com/photo/2022/03/30/16/20/seagull-7101482__340.jpg");
        images.add("https://cdn.pixabay.com/photo/2022/05/11/12/29/bird-7189272__340.png");
        images.add("https://cdn.pixabay.com/photo/2022/05/20/10/07/window-7209119__340.jpg");

        layoutIndicatorsContainer = findViewById(R.id.layoutIndicators);
        sliderImageViewPager = findViewById(R.id.viewPager);
        sliderImageViewPager.setOffscreenPageLimit(2); // default 값 1 , 2개를 먼저 올릴꺼야
        sliderImageViewPager.setAdapter(new ImageSliderAdapter(this, images));

    }

    private void addEvnetLisnter() {
        sliderImageViewPager.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageSelected(int position) {
                super.onPageSelected(position);
                Log.d("TAG", "position: " + position);
                setCurrentIndicator(position);
            }
        });
    }

    private void setupIndicators(int count) {
        ImageView[] indicators = new ImageView[count];
        // LayoutParams << 자바에서 배치 될지 설정 정의
        // xml 파일에서 "layout_" 가 붙는 속성들을 말한다.
        // LayoutParams 객체를 통해서 다룰 수 있다.

        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.WRAP_CONTENT,
                LinearLayout.LayoutParams.WRAP_CONTENT
        );
        params.setMargins(16, 8, 16, 8);

        for (int i = 0; i < indicators.length; i++) {
            indicators[i] = new ImageView(this);
            indicators[i].setImageDrawable(ContextCompat.getDrawable(this, R.drawable.bg_indicator_inactive));

            // indicators[i] = imageView
            indicators[i].setLayoutParams(params);
            layoutIndicatorsContainer.addView(indicators[i]);
        }

    }

    private void setCurrentIndicator(int position) {
        int childCount = layoutIndicatorsContainer.getChildCount();
        for (int i = 0; i < childCount; i++) {
            ImageView imageView = (ImageView) layoutIndicatorsContainer.getChildAt(i);

            if(i == position){
                imageView.setImageDrawable(ContextCompat
                                            .getDrawable(this,R.drawable.bg_indicator_active));
            }else{
                imageView.setImageDrawable(ContextCompat
                                            .getDrawable(this,R.drawable.bg_indicator_inactive));
            }

        }
    }


}