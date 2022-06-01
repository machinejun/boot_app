package com.example.mysecret_diary;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.preference.Preference;
import android.widget.Button;
import android.widget.NumberPicker;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    NumberPicker num1;
    NumberPicker num2;
    NumberPicker num3;

    Button openBtn;
    Button changeBtn;

    SharedPreferences preferences;
    boolean changePasswordMode = false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        preferences = getSharedPreferences("secrete", Activity.MODE_PRIVATE);
        initData();
        addEventLisnter();

    }

    @Override
    protected void onPause() {
        super.onPause();
        num1.setValue(0);
        num2.setValue(0);
        num3.setValue(0);
    }

    private void initData() {
        num1 = findViewById(R.id.numberPicker1);
        num1.setMinValue(0);
        num1.setMaxValue(9);
        num2 = findViewById(R.id.numberPicker2);
        num2.setMinValue(0);
        num2.setMaxValue(9);
        num3 = findViewById(R.id.numberPicker3);
        num3.setMinValue(0);
        num3.setMaxValue(9);

        openBtn = findViewById(R.id.openButton);
        changeBtn = findViewById(R.id.changePassword);
    }
    private void addEventLisnter(){
        openBtn.setOnClickListener(view -> {
            if(changePasswordMode){
                SharedPreferences.Editor editor = preferences.edit();
                String changePassword = getUserNum();
                editor.putString("password", changePassword);
                editor.commit();
                Toast.makeText(this, "비밀번호 설정 완료", Toast.LENGTH_SHORT).show();
                changeBtn.setBackgroundColor(Color.BLACK);
                changePasswordMode = false;
                return;
            }
            if(checkPassword()){
                Intent intent = new Intent(this,DiaryActivity.class);
                startActivity(intent);
            }else{
                showErrorAlertDialog();
            }

        });

        changeBtn.setOnClickListener(view -> {
            if(checkPassword()){
                changePasswordMode = true;
                changeBtn.setBackgroundColor(Color.RED);
                Toast.makeText(this, "비밀번호를 설정해주세요", Toast.LENGTH_SHORT).show();
            }else{
                showErrorAlertDialog();
            }
        });

    }

    private void showErrorAlertDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("실패")
                .setMessage("비밀번호가 잘못되었습니다")
                .setPositiveButton("닫기", (dialogInterface, i) -> {
                        // 동작 정의 하지 않음
                });
        builder.show();
    }

    private String getUserNum(){
        String selectNum = "" + num1.getValue() + num2.getValue() + num3.getValue();
        return selectNum;
    }

    private boolean checkPassword(){
        String password = preferences.getString("password","000");;
        String selectPassword = getUserNum();
        if(password.equals(selectPassword)){
            return true;
        }else{
            return false;
        }
    }
}