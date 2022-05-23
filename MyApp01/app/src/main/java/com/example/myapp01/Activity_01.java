package com.example.myapp01;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;

public class Activity_01 extends AppCompatActivity {
    private static final String TAG = "activity";
    public static final String KEY_NAME = "key name";
    private EditText nameEditText;
    private Button okBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_01);
        initDate();
        addEventListner();
    }

    private void initDate(){
        nameEditText = findViewById(R.id.nameEditView);
        okBtn = findViewById(R.id.okBtn);
    }

    private void addEventListner(){
        okBtn.setOnClickListener(view -> {
            //1. 현재 nameEidtText 뷰 컴포넌트에 값을 가져온다.
            //2. 필요하다면 방어적 코드를 짭시당
            //3. 화면 전환 로직 >> intent 사용

            String name = nameEditText.getText().toString();
            Intent intent = new Intent(this, Activity_02.class);
            intent.putExtra(KEY_NAME,name);
            startActivity(intent);
        });
    }

}