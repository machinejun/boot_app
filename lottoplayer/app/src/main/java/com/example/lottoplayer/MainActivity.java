package com.example.lottoplayer;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.NumberPicker;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = MainActivity.class.getName();

    private Button addBtn;
    private Button clearBtn;
    private Button runBtn;
    private NumberPicker numberPicker;
    private ArrayList<TextView> numberTextViewList = new ArrayList<>();
    private Set<Integer> pickerNumberSet = new HashSet<>();

    private boolean didRun = false;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initDate();
        addEventListener();
        Log.d(TAG, getRandomNum().toString());
    }

    private void initDate() {
        addBtn = findViewById(R.id.addNumber);
        clearBtn = findViewById(R.id.clear);
        runBtn = findViewById(R.id.runBtn);
        numberPicker = findViewById(R.id.numberPicker);
        numberPicker.setMinValue(1);
        numberPicker.setMaxValue(45);

        numberTextViewList.add(findViewById(R.id.firstBall));
        numberTextViewList.add(findViewById(R.id.secondBall));
        numberTextViewList.add(findViewById(R.id.thirthBall));
        numberTextViewList.add(findViewById(R.id.fourthBall));
        numberTextViewList.add(findViewById(R.id.fifthBall));
        numberTextViewList.add(findViewById(R.id.sixthBall));
    }

    private void addEventListener() {
        clearBtn.setOnClickListener(view -> {
            Log.d(TAG, "111111111111111");
            didRun = false;
            pickerNumberSet.clear();
            for (TextView tv : numberTextViewList) {
                tv.setVisibility(View.GONE);
            }
        });

        runBtn.setOnClickListener(view -> {
            // ???????????? list( 1 ~ 5 )
            List<Integer> list = getRandomNum();
            // set ????????? ???????????? ????????? ?????? ( 1 ~ 5 )
            Log.d(TAG,"list: " + list.toString());
            list.addAll(pickerNumberSet);
            Collections.sort(list);
            didRun = true;

            for (int i = 0; i < list.size(); i++) {
                numberTextViewList.get(i).setText(list.get(i).toString());
                numberTextViewList.get(i).setVisibility(View.VISIBLE);
                // 1 ~ 10 , 11 ~ 20, ......
                numberTextViewList.get(i).setBackground(setTextViewBackground(list.get(i)));
            }
        });

        addBtn.setOnClickListener(view -> {
            if(didRun){
                Toast.makeText(this, "????????? ?????? ??????", Toast.LENGTH_SHORT).show();
                return;
            }
            // 1.numberPicker ?????? ?????? ?????? ??????.
            int selectedNumber = numberPicker.getValue();
            Log.d(TAG, "seletedNumber :" + selectedNumber);

            // ????????? 5????????? ?????? ??????
            if (pickerNumberSet.size() >= 5) {
                Toast.makeText(this, "????????? 5????????? ?????? ???????????????.", Toast.LENGTH_SHORT).show();
                return;
            }
            // ????????? ?????? ????????? ?????? ??????
            if (pickerNumberSet.contains(selectedNumber)) {
                Toast.makeText(this, "?????? ????????? ???????????????.", Toast.LENGTH_SHORT).show();
                return;
            }

            TextView textView = numberTextViewList.get(pickerNumberSet.size());
            textView.setVisibility(View.VISIBLE);
            textView.setText(String.valueOf(selectedNumber));
            pickerNumberSet.add(selectedNumber);


        });


    }

    private List<Integer> getRandomNum() {
        ArrayList<Integer> list = new ArrayList<>();
        // 1 ~ 45 ?????? ????????? ??????
        for (int i = 1; i < 46; i++) {
            // ??????????????? ??????
            if (pickerNumberSet.contains(i)) {
                continue;
            }
            list.add(i); // 1 ~ 45?????? ?????? ??????
        }
        Collections.shuffle(list);
        return list.subList(0, 6 - pickerNumberSet.size());
    }

    private Drawable setTextViewBackground(int number) {
        // ?????? ????????? ????????? ????????? ????????? ??????
        Drawable drawable = null;
        if (number < 10) {
            drawable = ContextCompat.getDrawable(this, R.drawable.clycle);
        } else if(number < 20){
            drawable = ContextCompat.getDrawable(this, R.drawable.clycle2);
        }else if (number < 30){
            drawable = ContextCompat.getDrawable(this, R.drawable.clycle3);
        }else if (number <40){
            drawable = ContextCompat.getDrawable(this, R.drawable.clycle4);
        }else{
            drawable = ContextCompat.getDrawable(this, R.drawable.clycle5);
        }
        return drawable;
    }
}




