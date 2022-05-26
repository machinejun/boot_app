package com.example.samplelistapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RatingBar;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ArrayList<Color> sampledata = Color.getColorData();
        LinearLayout container = findViewById(R.id.colorContainer);
        LayoutInflater inflater = LayoutInflater.from(this);

        sampledata.forEach(color -> {
            View view = inflater.inflate(R.layout.item_color, container, false);
            ImageView itemImg = view.findViewById(R.id.colorImg);
            TextView itemName = view.findViewById(R.id.colorName);
            TextView itemRGB = view.findViewById(R.id.RGBcode);
            RatingBar ratingBar = view.findViewById(R.id.favorite);

            Glide.with(view).load(color.getImageUrl()).circleCrop().into(itemImg);
            itemName.setText(color.getName());
            itemRGB.setText(color.getRGBcode());
            ratingBar.setRating(color.getFavorite());
            container.addView(view);
        });
    }

}