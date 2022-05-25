package com.example.mybanner;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

public class Fragment1 extends Fragment {


    public Fragment1() {

    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_1, container, false);
        ImageView imageView = view.findViewById(R.id.img1);
        Glide.with(this).load("https://i.picsum.photos/id/738/200/300.jpg?hmac=x-GpfBAQrKyKnrXqne7UJ3rdVnkGD7e-uRhpCcZWb9I").circleCrop().into(imageView);
        return view;
    }
}