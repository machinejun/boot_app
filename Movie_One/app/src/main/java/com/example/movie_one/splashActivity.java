package com.example.movie_one;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.TextView;

public class splashActivity extends AppCompatActivity {
    // 앱에 들어가면 처음 뜨는 로고 화면 = splash 화면


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        /*
            애니메이션 세팅
            1. 스테이스 바 제거
         */
         getWindow().setFlags(
                 WindowManager.LayoutParams.FLAG_FULLSCREEN,
                 WindowManager.LayoutParams.FLAG_FULLSCREEN
         );
        TextView textView = findViewById(R.id.splashTextView);

        Animation slideAnimation = AnimationUtils
                .loadAnimation(this, R.anim.slide_in_bottom); // 현재의 컨텍스트에서 슬라이드 애니메이션 등록
        textView.startAnimation(slideAnimation); // 애니메이션 등록

        new Handler().postDelayed(new Runnable() {
            // 쓰레드 슬립을 하게 되면 그림을 그려주는 ui 쓰레드가 멈춰버린다.
            // 즉 그림을 그려주는 쓰레드가 동작이 완성되는 것보다 코드 흐름이 빠르게 되어서 애니메이션이
            // 일어 나지 않는다.
            @Override
            public void run() {
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                // getApplicationContext 는 전체 앱의 context 이다.
                startActivity(intent);
                // splashActivty 위에 MainActivity 가 올라간다.
                finish();
                // splashActivty 제거
            }
        }, 1200);


    }
}