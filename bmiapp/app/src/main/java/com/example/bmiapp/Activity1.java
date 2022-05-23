package com.example.bmiapp;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputLayout;

public class Activity1 extends AppCompatActivity {
    private TextInputLayout heightEt;
    private TextInputLayout weightEt;
    private Button submitBtn;
    private ProgressBar bar;
    int pvalue = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_1);
        initDate();
        addEventListener();


    }

    private void initDate(){
        heightEt = findViewById(R.id.heightEt);
        weightEt = findViewById(R.id.weightEt);
        submitBtn = findViewById(R.id.submitBtn);
        bar = (ProgressBar) findViewById(R.id.progressBar);
        bar.setVisibility(View.INVISIBLE);
    }

    private void addEventListener(){

        submitBtn.setOnClickListener(view -> {
            double[] data = new double[2];
            Editable heightEdit = heightEt.getEditText().getText();
            Editable weightEdit = weightEt.getEditText().getText();

            if(heightEdit.length() < 1 || weightEdit.length() < 1 ){
                Toast.makeText(this,"올바른 값을 입력해주세요",Toast.LENGTH_SHORT);
                return;
            }

            data[0] = Math.round(Double.parseDouble(heightEdit.toString())*10/10.0);
            data[1] = Math.round(Double.parseDouble(weightEdit.toString())*10/10.0);

            Log.d("TAG", "height: " + data[0]);
            Log.d("TAG", "weight: " + data[1]);
            Intent intent = new Intent(this,Activity2.class);
            intent.putExtra("info",data);
            bar.setVisibility(View.VISIBLE);

            for (int i = 0; i <10; i++){
                bar.setProgress(pvalue++,true);
                try {
                    Thread.sleep(80);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }


            startActivity(intent);



        });


    }






}