package com.example.recyclemyapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.example.recyclemyapp.adapter.ColorAdapter;
import com.example.recyclemyapp.interfaces.ChangeFavorite;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    RecyclerView view;
    ColorAdapter adapter = new ColorAdapter(Color.getColorData(), this, new ChangeFavorite() {
        @Override
        public void changeFavorite(View view, int position) {
            Log.d("TAG",position + "");
            Intent intent = new Intent(getApplication(), DetailColor.class);
            intent.putExtra("obj", Color.getColorData().get(position));
            //repaint(position);
            startActivity(intent);
        }
    });
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ArrayList<Color> sample = Color.getColorData();
        view = findViewById(R.id.recylerView);
        view.setAdapter(adapter);
        view.setLayoutManager(new LinearLayoutManager(this));

    }

    private void repaint(int position){
        view.setLayoutManager(new LinearLayoutManager(this));
    }


}