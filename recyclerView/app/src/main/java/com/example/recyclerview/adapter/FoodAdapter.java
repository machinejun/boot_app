package com.example.recyclerview.adapter;


// 뷰 홀더 만들기

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.CenterCrop;
import com.bumptech.glide.load.resource.bitmap.RoundedCorners;
import com.example.recyclerview.R;
import com.example.recyclerview.models.Food;

import java.util.ArrayList;

public class FoodAdapter extends RecyclerView.Adapter<FoodAdapter.MyViewHolder>{
    // 멤버 변수
    ArrayList<Food> list;
    Context context;

    public FoodAdapter(ArrayList<Food> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // new ViewHolder 생성
        View itemView = LayoutInflater
                .from(context)
                .inflate(R.layout.item_food, parent, false);
        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        // BindeViewHolder 화면과 연결
        // 데이터 맵핑
        Log.d("TAG", position + " << position");
        Food food = list.get(position);
        Glide.with(context)
                .load(food.getThumbnail())
                .transform(new CenterCrop(), new RoundedCorners(30))
                .into(holder.thumNamil);
        holder.titleTextView.setText(food.getTitle());
        holder.subtitleTextView.setText(food.getSubTitle());
        holder.detailTextView.setText(food.getDetail());



    }

    @Override
    public int getItemCount() {
        // 아이템 갯수 표시
        return list.size();
    }

    // 1. 내부 클래스 만들기
    public class MyViewHolder extends RecyclerView.ViewHolder{

        ImageView thumNamil;
        TextView titleTextView;
        TextView subtitleTextView;
        TextView detailTextView;


        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            thumNamil = itemView.findViewById(R.id.thumnailImageView);
            titleTextView = itemView.findViewById(R.id.titleTextView);
            subtitleTextView = itemView.findViewById(R.id.subTitleTextView);
            detailTextView = itemView.findViewById(R.id.detailTextView);

            itemView.setOnClickListener(view -> {
                Log.d("TAG","hello" +getLayoutPosition());
                Toast.makeText(view.getContext(), "Test" + getLayoutPosition(), Toast.LENGTH_SHORT).show();
            });


        }
    }
}
