package com.example.bmiapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    private Button nextButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initDate();
        addEventListener();
    }

    private void initDate(){
        nextButton = findViewById(R.id.nextButton);
    }

    private void addEventListener(){
        nextButton.setOnClickListener(view -> {
            Log.d("TAG","버튼 클릭");
            Intent intent = new Intent(this, Activity1.class);
            startActivity(intent);
        });
    }
}