package com.example.mysecret_diary;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.widget.EditText;

public class DiaryActivity extends AppCompatActivity {

    EditText diaryEditText;
    // 메세지 큐 : FIFO
    Handler handler = new Handler(Looper.getMainLooper()); // 루퍼

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_diary);

        diaryEditText = findViewById(R.id.diaryEditText);
        // 사용자가 이전에 적었던 비밀 데스노트(일기장) 불러와야 한다.

        SharedPreferences notePreferece = getSharedPreferences("diary", Context.MODE_PRIVATE);
        diaryEditText.setText(notePreferece.getString("detail", ""));

        ////////// 새로운 쓰레드를 만들어서 비동기로 저장
        // 쓰레드간 통신
        // 쓰레드 기능 구현 / 다른 작업 영역
        Runnable runnable = () -> {
            SharedPreferences Preferece = getSharedPreferences("diary", Context.MODE_PRIVATE);
            SharedPreferences.Editor editor= Preferece.edit();
            editor.putString("detail", diaryEditText.getText().toString());
            editor.apply();
        };


        // 사용자가 한글자 입력할 때마다 이벤트 리스너를 등록해서 변경 사항을 가지고 오기
        diaryEditText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                // 한글자 한글자 입력이 들어 올 때마다 저장한다.
                ///////// 다른 쓰레드에게 일해달라고 요청
                handler.removeCallbacks(runnable);
//                handler.post(runnable);

                // a : 0.5 delay
                // ab : 0.5 delay
                // abc : 0.5 delay
                // abcd : 0.5 delay  >> 2초 삭제제
               handler.postDelayed(runnable, 500);
            }

            @Override
            public void afterTextChanged(Editable editable) {
            }
        });



    }


}