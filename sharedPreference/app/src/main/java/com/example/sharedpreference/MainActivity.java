package com.example.sharedpreference;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Button btnSave;
    private Button btnLoad;
    private Button btnDelete;
    private Button btnDeleteAll;
    SharedPreferences sp1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initData();
        addEventListner();

        /*
        SharedPreference = 경량화된 데이터를 꺼내기 위한 친구
        - Tag 를 설정해주어야 한다.

        Mode
        - MODE_PRIVATE : 생성한 어플리케이션에서만 사용
        - MODE_WORLD_READABLE : 다른 어플리케이션에서 사용 가능 but 읽을 수만 있다
        - MODE_WORLD_WRITEABLE : 다른 어플리케이션에서 사용 가능(기록 가능)
        */
        sp1 = getSharedPreferences("sp1", MODE_PRIVATE);
    }

    private void initData() {

        btnSave = findViewById(R.id.saveBtn);
        btnLoad = findViewById(R.id.loadBtn);
        btnDelete = findViewById(R.id.deleteBtn);
        btnDeleteAll = findViewById(R.id.allDeleteBtn);
    }

    private void addEventListner() {
        btnSave.setOnClickListener(view -> {
            /* name, age, isMarried 데이터 저장하는 기능을 만들어 주세요
                1. sharedepreference를 불러온다.
                2. 수정 모드로 만들어 주어야한다.
                3. 저장할 데이터를 입력한다.
                4. 비동기 방식으로 데이터를 완전히 저장한다.
            */
            SharedPreferences.Editor editor = sp1.edit();

            // 데이터 입력하기 >> ★ 데이터를 넣기 위해서는 수정 모드로 변경해주어야한다.
            editor.putString("name", "홍길동"); // 저장 안됨!!
            editor.putInt("age", 25);
            editor.putBoolean("isMarried", true);
            editor.apply();// 꼭 apply 해주어야지만 저장이 이루어진다.
            //editor.commit();
            /*
            apply 와 commit 의 차이점
            - apply : 스레드를 블록 시키지 않는다.
                    => 비동기 방식 (비동기는 동시에 일어나지 않는다를 의미합니다. 요청과 결과가 동시에 일어나지 않을거라는 약속입니다.)
                    => 저장에 성공여부 true, false 값을 주지 않는다.

            - commit : 스레드가 블록된다.
                     => 동기 방식
                     => commit 은 저장을 성공하면 boolean 타입인 true를 반환한다.
         */


        });
        btnLoad.setOnClickListener(view -> {
            SharedPreferences preferences = getSharedPreferences("sp1", MODE_PRIVATE); // 데이터 가지고 오기
            //데이터 읽어 보기
            String name = preferences.getString("name", ""); // (키값, 디폴트값)
            int age = preferences.getInt("age", 0);
            boolean isMarried = preferences.getBoolean("isMarried", false);
            Toast.makeText(this, "age: " + age, Toast.LENGTH_SHORT).show();
            Log.d("TAG", "name 값 확인 : " + name);
            Log.d("TAG", "age 값 확인 : " + age);
            Log.d("TAG", "isMarried 값 확인 : " + isMarried);
        });

        btnDelete.setOnClickListener(view -> {
            // 메서드 체이닝 방식으로 코드 작성해보기
            // age 삭제
            getShared("sp1").edit().remove("age").apply();
            btnLoad.callOnClick();  // 코드상으로 버튼을 눌렀다 명령하기 !!

        });
        btnDeleteAll.setOnClickListener(view -> {
            getShared("sp1").edit().clear().apply();
            btnLoad.callOnClick();
        });

    }

    private SharedPreferences getShared(String name) {
        return getSharedPreferences(name, MODE_PRIVATE);
    }
}