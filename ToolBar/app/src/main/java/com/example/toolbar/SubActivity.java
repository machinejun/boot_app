package com.example.toolbar;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class SubActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        Button button = findViewById(R.id.finish);

        int value1 = getIntent().getIntExtra("value1", 0);
        Log.d("TAG","값 받음: " +  value1);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // 값을 메인액티비티에다가 보낼 것이다.
                Intent resultIntent = new Intent();
                resultIntent.putExtra("result",value1 + 10);
                // 반드시 기억할것
                setResult(Activity.RESULT_OK, resultIntent);
                finish();
            }
        });
    }
}