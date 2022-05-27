package com.example.myapplicatio.Adapter;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.myapplicatio.R;

import java.util.ArrayList;

public class ImageSliderAdapter extends RecyclerView.Adapter<ImageSliderAdapter.ViewHolder>{

    private Context context;
    private ArrayList<String> slideImages;
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater
                .from(context)
                .inflate(R.layout.item_image_slider, parent, false);

        return new ViewHolder(itemView);
    }

    public ImageSliderAdapter(Context context, ArrayList<String> slideImages) {
        this.context = context;
        this.slideImages = slideImages;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.bindSliderImage(slideImages.get(position));
    }

    @Override
    public int getItemCount() {
        return slideImages.size();
    }
    // 뷰홀더 생상



    protected class ViewHolder extends RecyclerView.ViewHolder{

        private ImageView imageView;



        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.imageSlider);
        }

        public void bindSliderImage(String imgUrl){
            Glide.with(context)
                    .load(imgUrl)
                    .centerCrop()
                    .into(imageView);

        }
    }
}
