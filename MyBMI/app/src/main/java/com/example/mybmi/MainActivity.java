package com.example.mybmi;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputLayout;

public class MainActivity extends AppCompatActivity {

    private TextInputLayout weightEt;
    private TextInputLayout heightEt;
    private Button submitBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        heightEt = findViewById(R.id.heightEt);
        weightEt = findViewById(R.id.weightEt);
        submitBtn = findViewById(R.id.submitBtn);

        submitBtn.setOnClickListener(view -> {
            Editable weightable = weightEt.getEditText().getText();
            Editable heightable = heightEt.getEditText().getText();


            if(weightable.length() < 1 || heightable.length() < 1){
                Toast.makeText(this, "빈 값이 있습니다.",Toast.LENGTH_SHORT).show();
                return;
            }

            try{
                int height = Integer.parseInt(heightable.toString());
                int weight = Integer.parseInt(weightable.toString());

                Intent intent = new Intent(this, BmiResultActivity.class);
                intent.putExtra("height", height);
                intent.putExtra("weight", weight);
                startActivity(intent);
            }catch (NumberFormatException e){
                Toast.makeText(this, "잘못 입력하셨습니다.",Toast.LENGTH_SHORT).show();
            }

            //int 처리


        });
    }
}