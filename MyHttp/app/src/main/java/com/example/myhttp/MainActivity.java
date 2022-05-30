package com.example.myhttp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.NetworkOnMainThreadException;
import android.util.Log;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.myhttp.models.Todo;
import com.example.myhttp.models.User;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Type;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    Button startBtn;
    TextView textView;
    ArrayList<User> userList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView = findViewById(R.id.textview1);
        startBtn = findViewById(R.id.startBtn);
        startBtn.setOnClickListener(view -> {
            if(textView.getText().equals("")){
                httpGetTest();
            }else{
                textView.setText("");
            }

        });



    }

    private void httpGetTest() {
        String urlString = "https://jsonplaceholder.typicode.com/posts";
        Thread thread = new Thread(() -> {
            try {
                URL url = new URL(urlString);
                HttpURLConnection conn = (HttpURLConnection) url.openConnection();
                conn.setRequestMethod("GET");

                if (conn.getResponseCode() == HttpURLConnection.HTTP_OK) {
                    BufferedReader reader = new BufferedReader(new InputStreamReader(
                            conn.getInputStream(), "UTF-8"));

                    Type userListType = new TypeToken<ArrayList<User>>() {
                    }.getType();
                    userList = new Gson().fromJson(reader, userListType);
                    for (User t : userList) {
                        Log.d("TAG", t.toString());
                    }
                }
            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
        thread.start();
        try {
            thread.join();
            textView.setText(userList.get(0).body);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}