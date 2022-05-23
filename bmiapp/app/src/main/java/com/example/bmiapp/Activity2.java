package com.example.bmiapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Layout;
import android.util.Log;
import android.view.View;
import android.widget.LinearLayout;

public class Activity2 extends AppCompatActivity {
    private LinearLayout underweight;
    private LinearLayout normal;
    private LinearLayout overweight;
    private LinearLayout obesity;
    private LinearLayout extermelyfat;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_2);

        underweight = findViewById(R.id.underweight);
        normal = findViewById(R.id.normalfat);
        overweight = findViewById(R.id.overweight);
        obesity = findViewById(R.id.obesity);
        extermelyfat = findViewById(R.id.external);

        underweight.setVisibility(View.INVISIBLE);
        normal.setVisibility(View.INVISIBLE);
        overweight.setVisibility(View.INVISIBLE);
        obesity.setVisibility(View.INVISIBLE);
        extermelyfat.setVisibility(View.INVISIBLE);


        if(getIntent() != null){
            int result = calculateBMI(getIntent().getDoubleArrayExtra("info"));
            Log.d("TAG","결과: " + result);

            if(result < 18){
                underweight.setVisibility(View.VISIBLE);
            }else if(result < 23){
                normal.setVisibility(View.VISIBLE);
            }else if(result < 25){
                overweight.setVisibility(View.VISIBLE);
            }else if(result < 30){
                obesity.setVisibility(View.VISIBLE);
            }else{
                extermelyfat.setVisibility(View.VISIBLE);
            }
        }
    }

    private int calculateBMI(double[] data){
        int result = (int) (data[1] / Math.pow(data[0]/100, 2));
        return result;
    }
}