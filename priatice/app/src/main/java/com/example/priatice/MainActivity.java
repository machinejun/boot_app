package com.example.priatice;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.media.Image;
import android.net.UrlQuerySanitizer;
import android.os.Bundle;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class MainActivity extends AppCompatActivity {
    ImageView imageView;
    ImageView imageView2;
    Bitmap bitmap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imageView = findViewById(R.id.img);
        imageView2 = findViewById(R.id.img2);
        Thread thread =new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    URL url = new URL("https://cdn.pixabay.com/photo/2022/02/21/07/12/woman-7025944_960_720.jpg");
                    HttpURLConnection conn = (HttpURLConnection) url.openConnection();
                    conn.connect();

                    InputStream inputStream = conn.getInputStream();
                    BufferedInputStream bi = new BufferedInputStream(inputStream);
                    bitmap= BitmapFactory.decodeStream(bi);

                } catch (MalformedURLException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
        thread.start();
        try{
            thread.join();
            imageView.setImageBitmap(bitmap);

            Glide.with(this)
                    .load("https://cdn.pixabay.com/photo/2022/05/16/11/01/pugs-7200102__340.png")
                    .into(imageView2);

        }catch (InterruptedException e){

        }

    }
}