package com.example.recyclemyapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import java.io.Serializable;
// 역직렬화 byte --> OBJECT
public class DetailColor extends AppCompatActivity implements Serializable {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_color);

        if(getIntent() != null){
            Color color = (Color)getIntent().getSerializableExtra("obj");
            // 오브젝트 개체로 넘어오기 때문에 다운캐스팅이 필요함
            // 역직렬화 byte --> OBJECT
            Log.d("TAG", color.toString());
        }

    }

}