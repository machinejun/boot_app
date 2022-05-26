package com.example.recyclemyapp.adapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.recyclemyapp.Color;
import com.example.recyclemyapp.R;
import com.example.recyclemyapp.interfaces.ChangeFavorite;

import java.util.ArrayList;

public class ColorAdapter extends RecyclerView.Adapter<ColorAdapter.ViewHolder>{
    ArrayList<Color> list;
    Context context;
    ChangeFavorite changeFavorite;

    public ColorAdapter(ArrayList<Color> list, Context context, ChangeFavorite changeFavorite) {
        this.list = list;
        this.context = context;
        this.changeFavorite = changeFavorite;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Log.d("TAG","onCreateViewHolder");
        View view = LayoutInflater
                .from(context)
                .inflate(R.layout.item_color, parent, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Log.d("TAG","onBindViewHolder");
        Color color = list.get(position);
        Glide.with(context)
                .load(color.getImageUrl())
                .circleCrop()
                .into(holder.colorImg);
        holder.colorName.setText(color.getName());
        holder.colorRGB.setText(color.getRGBcode());
        holder.ratingBar.setRating(color.getFavorite());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    protected class ViewHolder extends RecyclerView.ViewHolder{

        ImageView colorImg;
        TextView colorName;
        TextView colorRGB;
        RatingBar ratingBar;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            Log.d("TAG", "viewHolder");
            colorImg = itemView.findViewById(R.id.colorImg);
            colorName = itemView.findViewById(R.id.colorName);
            colorRGB = itemView.findViewById(R.id.RGBcode);
            ratingBar = itemView.findViewById(R.id.favorite);
            itemView.setOnClickListener(view -> {
                Color color = list.get(getLayoutPosition());
                Log.d("TAG", color.getName());
                Log.d("TAG", color.getFavorite() + "");
                int i = color.getFavorite() + 1;
                if(i > 3){
                    i = 0;
                }
                color.setFavorite(i);
                changeFavorite.changeFavorite(itemView, getLayoutPosition());

            });
        }
    }
}
