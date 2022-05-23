package com.example.class_04;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity {
    private static final String LIFE_CYCLE = "live_cycle";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        /*
            상속객체의 onCreate 메서드 호출
         */
        setContentView(R.layout.activity_main);
        /*
            화면을 아래와 같은 xml 파일로 그려준다.(activity)
            처음에 화면을 그리는 것은 단 한번만 그려준다.
         */
        Log.d(LIFE_CYCLE, "onCreate~~~");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d(LIFE_CYCLE, "onStart~~~~");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d(LIFE_CYCLE, "onRestart");
    }

    @Override
    protected void onResume() {
        super.onResume();

        Log.d(LIFE_CYCLE,"onResume~~");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d(LIFE_CYCLE, "onPause~~");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d(LIFE_CYCLE,"onStop");
        //Log.d(LIFE_CYCLE,"destory~~~");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(LIFE_CYCLE,"destory~~~");
    }
}