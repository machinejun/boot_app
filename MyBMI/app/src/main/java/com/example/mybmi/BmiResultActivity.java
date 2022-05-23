package com.example.mybmi;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

public class BmiResultActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bmi_result);

        if(getIntent() != null){
            int height = getIntent().getIntExtra("height",0);
            int weight = getIntent().getIntExtra("weight",0);

            double bmiValue = weight / Math.pow(height/100.0, 2);
            Log.d("TAG","result: " + bmiValue);
            if(bmiValue < 20){
                Log.d("TAG","result: 저체중");
            }else if(bmiValue <= 24){
                Log.d("TAG","result: 정상");
            }else if(bmiValue <= 29){
                Log.d("TAG","result: 과체중");
            }else if(bmiValue >= 30){
                Log.d("TAG","result: 비만");
            }

        }
    }
}