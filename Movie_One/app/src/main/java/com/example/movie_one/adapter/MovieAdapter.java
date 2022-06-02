package com.example.movie_one.adapter;


import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.FitCenter;
import com.bumptech.glide.load.resource.bitmap.RoundedCorners;
import com.example.movie_one.R;
import com.example.movie_one.models.Movie;

import java.util.ArrayList;
import java.util.List;

public class MovieAdapter extends RecyclerView.Adapter<MovieAdapter.MyViewHolder> {

    private List<Movie> list = new ArrayList<Movie>();

    // 생성자에서 데이터를 전달했을 때와 다르게
    // >>>> 네트워크를 통신이기 때문에 화면을 그리는 시점보다
    //      더 늦게 데이터가 도달 할 수 있다.


    /**
     * 통신이 완료되었을 때 해당 메서드를 호출하고 갱신을 알림
     * @param list = 서버로 부터 전송받은 무비리스트
     */
    public void addItemList(List<Movie> list) {
        this.list = list;
        notifyDataSetChanged(); // 데이터가 변경되었다라고 알려줌 >> 화면을 다시 그림 == repaint()
    }

    /**
     * 리사이클러 뷰에 새로운 리사이클러 뷰가 필요할 때 호출
     * 프레그먼트 안에 view들의 레이아웃을 팽창 시키는 역할
     * @param parent = fragment_movie 의 리사이클뷰
     * @param viewType
     * @return
     */
    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View itemView = inflater.inflate(R.layout.item_movie_card, parent, false);
        return new MyViewHolder(itemView);
    }

    /**
     * onCreateViewHolder에서 리턴된 저 친구가 여기 holder로 들어온다.
     * 새로 생성된 holder는 여기서 그려진다.
     * @param holder new 한 뷰홀더
     * @param position 화면에서 보여지는 친구들 위치
     */
    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        Movie movie = list.get(position);
        holder.setItem(movie);


        // 2가지 타입 >> 1. 여기서 바로 셋팅, 2. view holder 안에서 세팅

        //1. 여기서 셋팅
//        holder.titleTextView.setText(movie.getTitle());
//        holder.ratingTextView.setText(String.valueOf(movie.getRating()));
//        holder.ratingBar.setRating((float) movie.getRating());
//        Glide.with(holder.posterImg.getContext()).load(movie.getMediumCoverImg())
//                .placeholder(R.drawable.round_image)
//                .transform(new FitCenter(), new RoundedCorners(20))
//                .into(holder.posterImg);

    }
    @Override
    public int getItemCount() {
        return list.size();
    }

    // view binding 뷰결합 안됨 , 직접 해야한다 -> 단 방향
    // data binding 뷰결합 -> 양방향
    protected class MyViewHolder extends RecyclerView.ViewHolder {
        private View itemView;
        private ImageView posterImg;
        private TextView titleTextView;
        private TextView ratingTextView;
        private RatingBar ratingBar;

        // itemView에 선언한 데이터 타입들을 선언하고 생성 시점에 R.id.xxx 연결해주면 된다.

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            this.itemView = itemView;
            posterImg = itemView.findViewById(R.id.posterImg);
            titleTextView = itemView.findViewById(R.id.titleTextView);
            ratingTextView = itemView.findViewById(R.id.ratingTextView);
            ratingBar = itemView.findViewById(R.id.ratingBar);
        }

        public void setItem(Movie movie){
            titleTextView.setText(movie.getTitle());
            ratingTextView.setText(String.valueOf(movie.getRating()));
            ratingBar.setRating((float) movie.getRating());
            Glide.with(posterImg.getContext()).load(movie.getMediumCoverImg())
                    .placeholder(R.drawable.round_image)
                    .transform(new FitCenter(), new RoundedCorners(20))
                    .into(posterImg);
        }
    }

}
