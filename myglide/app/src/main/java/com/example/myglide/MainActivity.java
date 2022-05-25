package com.example.myglide;

import android.os.Bundle;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        // 인물 사진 그리기
        ImageView imageView1 = findViewById(R.id.gImageView1);
        ImageView imageView2 = findViewById(R.id.gImageView2);
        ImageView imageView3 = findViewById(R.id.gImageView3);
        ImageView imageView4 = findViewById(R.id.gImageView4);
        ImageView imageView5 = findViewById(R.id.gImageView5);
        ImageView imageView6 = findViewById(R.id.gImageView6);

        Glide.with(this).load("https://picsum.photos/200/300?random=1").circleCrop().into(imageView1);
        Glide.with(this).load("https://picsum.photos/200/300?random=10").circleCrop().into(imageView2);
        Glide.with(this).load("https://picsum.photos/200/300?random=3").circleCrop().into(imageView3);
        Glide.with(this).load("https://picsum.photos/200/300?random=12").circleCrop().into(imageView4);
        Glide.with(this).load("https://picsum.photos/200/300?random=5").circleCrop().into(imageView5);
        Glide.with(this).load("https://picsum.photos/200/300?random=8").circleCrop().into(imageView6);


    }
}