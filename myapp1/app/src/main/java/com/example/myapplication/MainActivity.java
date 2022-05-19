package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import java.util.NoSuchElementException;
import java.util.StringTokenizer;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "TAG";
    private TextView one; //
    private TextView two;
    private TextView three;
    private TextView four;
    private TextView five;
    private TextView six;
    private TextView seven;
    private TextView eight;
    private TextView nine;
    private TextView zero;
    private TextView plus;
    private TextView ca;
    private TextView result;
    private StringBuffer r = new StringBuffer();

    String newValue = "0";
    String oldValue = "0";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.calculator);
        initData(); // 호출되면 stack 메모리에 올라간다.
        addEventListener();
    }

    // 연산을 하기 위해서는 xml 문서를 java로 변환해와야 한다.

    private void initData() {
        one = findViewById(R.id.one);
        two = findViewById(R.id.two);
        three = findViewById(R.id.three);
        four = findViewById(R.id.four);
        five = findViewById(R.id.five);
        six = findViewById(R.id.six);
        seven = findViewById(R.id.seven);
        eight = findViewById(R.id.eight);
        nine = findViewById(R.id.nine);
        ca = findViewById(R.id.ca);
        zero = findViewById(R.id.zero);
        plus = findViewById(R.id.plus);
        result = findViewById(R.id.result);
        // 메모리에 올라가지 않은 애를 올리면 안된다. ex two = findViewById(R.id.button); 하면
        // 컴파일 시점에서는 위치를 알 수 있지만 런타임 시점에서는 알 수 없기 때문에 에러가 발생한다.
        System.out.println("initData 메서드 호출");
    }

    private void addEventListener() {
        one.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d(TAG, "one가 눌러졌어요");
                r.append("1");
                result.setText(r);
                checktPlus();
            }
        });
        two.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d(TAG, "two가 눌러졌어요");
                r.append("2");
                result.setText(r.toString());
                checktPlus();
            }
        });
        three.setOnClickListener(view -> {
            Log.d(TAG, "three가 눌러졌어요");
            r.append("3");
            result.setText(r);
            checktPlus();
        });
        four.setOnClickListener(view -> {
            Log.d(TAG, "four가 눌러졌어요");
            r.append("4");
            result.setText(r);
            checktPlus();
        });
        five.setOnClickListener(view -> {
            Log.d(TAG, "five가 눌러졌어요");
            r.append("5");
            result.setText(r);
            checktPlus();
        });
        six.setOnClickListener(view -> {
            Log.d(TAG, "siz가 눌러졌어요");
            r.append("6");
            result.setText(r);
            checktPlus();
        });
        seven.setOnClickListener(view -> {
            Log.d(TAG, "seven가 눌러졌어요");
            r.append("7");
            result.setText(r);
            checktPlus();
        });
        eight.setOnClickListener(view -> {
            Log.d(TAG, "eight가 눌러졌어요");
            r.append("8");
            result.setText(r);
            checktPlus();
        });
        nine.setOnClickListener(view -> {
            Log.d(TAG, "nine가 눌러졌어요");
            r.append("9");
            result.setText(r);
            checktPlus();
        });
        ca.setOnClickListener(view -> {
            Log.d(TAG, "CA가 눌러졌어요");
            r.setLength(0);
            result.setText("0");
        });
        zero.setOnClickListener(view -> {
            Log.d(TAG, "Zero가 눌러졌어요");
            r.append("0");
            result.setText(r.toString());
            checktPlus();
        });
        plus.setOnClickListener(view -> {
            r.append("+");
            //result.setText(r.toString());
            Log.d(TAG, "+가 눌러졌어요");
        });



    }

    private void checktPlus(){
        try {
            StringTokenizer st = new StringTokenizer(r.toString(),"+");
            String r1= st.nextToken();
            String r2 = st.nextToken();
            int calR = Integer.parseInt(r1) + Integer.parseInt(r2);
            r.setLength(0);
            r.append(calR);
            result.setText("0");
            result.setText(r.toString());
        }catch (NoSuchElementException e){

        }

    }
}