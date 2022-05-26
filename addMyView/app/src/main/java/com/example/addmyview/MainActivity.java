package com.example.addmyview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ArrayList<Fruit> sampleData = Fruit.getFruits();
        // 컨테이너 가져오기
        LinearLayout container = findViewById(R.id.fruitcontainer);
        // 객체 가져오기
        LayoutInflater inflater = LayoutInflater.from(this);
        // inflater 객체를 이용해서 xml 파일을 메모리에 올리고 설정


        sampleData.forEach(fruit -> {
            View itemView = inflater.inflate(R.layout.item_food, container, false);
            ImageView fruitImageView = itemView.findViewById(R.id.fruitImageView);
            TextView itemName = itemView.findViewById(R.id.fruitNameTextView);
            TextView itemPrice = itemView.findViewById(R.id.fruitPrice);
            TextView itemCount = itemView.findViewById(R.id.fruitCount);

            Glide.with(itemView)
                    .load(fruit.imageUrl)
                    .circleCrop()
                    .into(fruitImageView);
            itemName.setText(fruit.name);
            itemPrice.setText(fruit.price);
            itemCount.setText(fruit.count);
            container.addView(itemView);
        });
    }
}