package com.example.bmiapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

public class Activity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_2);

        if(getIntent() != null){
            int result = calculateBMI(getIntent().getDoubleArrayExtra("info"));
            Log.d("TAG","결과: " + result);

            if(result < 18){

            }else if(result < 23){

            }else if(result < 25){

            }else if(result < 30){

            }else{

            }
        }
    }

    private int calculateBMI(double[] data){
        int result = (int) (data[1] / Math.pow(data[0]/100, 2));
        return result;
    }
}