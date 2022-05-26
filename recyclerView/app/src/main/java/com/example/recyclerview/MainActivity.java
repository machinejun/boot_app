package com.example.recyclerview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.recyclerview.adapter.FoodAdapter;
import com.example.recyclerview.models.Food;

import java.util.ArrayList;

/**
 * RecylerView
 * >> ListView 개선판
 * >> ViewHolder 포함 (findviewByid)
 * >> 디자인 변경에 대처가 유연하다.
 * ----------------------------------
 * >> LayoutManager, Adapter 클래스
 */

public class MainActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ArrayList<Food> tmepData = Food.getSampleData();
        // 리사이클러 뷰를 사용
        // 1. Adapter 클래스를 직접 생성해야한다.
        // 2. LayoutManger 생성 해서 Adapter 클래스와 연결해야 한다.

        RecyclerView view = findViewById(R.id.recylerView);
        view.setAdapter(new FoodAdapter(Food.getSampleData(), this));
        view.setLayoutManager(new LinearLayoutManager(this));
        //view.setLayoutManager(new GridLayoutManager(this,2));




    }
}