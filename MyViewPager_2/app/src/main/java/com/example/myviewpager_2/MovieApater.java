package com.example.myviewpager_2;

        import android.content.Context;
        import android.view.LayoutInflater;
        import android.view.View;
        import android.view.ViewGroup;
        import android.widget.ImageView;

        import androidx.annotation.NonNull;
        import androidx.recyclerview.widget.RecyclerView;

        import com.bumptech.glide.Glide;

        import java.util.ArrayList;

class MovieSliderAdapter extends RecyclerView.Adapter<MovieSliderAdapter.ViewHolder>{
    private Context context;
    private ArrayList<String> images = new ArrayList<>();

    public MovieSliderAdapter(Context context, ArrayList<String> images) {
        this.context = context;
        this.images = images;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context)
                .inflate(R.layout.image_view_slider, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.setImageView(images.get(position));
    }

    @Override
    public int getItemCount() {
        return images.size();
    }


    class ViewHolder extends RecyclerView.ViewHolder{
        ImageView imageView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.imageViewSliderItemContainer);

        }

        public void setImageView(String imageURL) {
            Glide.with(context)
                    .load(imageURL)
                    .centerCrop()
                    .into(imageView);
        }
    }
}
