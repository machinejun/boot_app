package com.example.myapp01;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

public class Activity_02 extends AppCompatActivity {
    private TextView textView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_02);

        textView = findViewById(R.id.nameTextView);

        // 값을 받는 방법
        // 값이 없다면 기본 값을 0으로 셋팅
        // 방어적 코드가 필요하다.
        if(getIntent() != null){
//            int numberTemp = getIntent().getIntExtra("number",0);
//            String stringTemp = getIntent().getStringExtra("myString");
//            // String 은 자동으로 null 로 초기화 해준다.
//            Log.d("TAG", "numberTemp: " + numberTemp);
//            Log.d("TAG", "myStringTemp: " + stringTemp);
            String str = getIntent().getStringExtra(Activity_01.KEY_NAME);
            textView.setText(str);


        }


    }
}