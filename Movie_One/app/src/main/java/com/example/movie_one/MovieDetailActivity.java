package com.example.movie_one;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.bumptech.glide.Glide;
import com.example.movie_one.databinding.ActivityMovieDetailBinding;
import com.example.movie_one.models.Movie;
import com.example.movie_one.utils.Define;

public class MovieDetailActivity extends AppCompatActivity {
    private Movie movie;
    private ActivityMovieDetailBinding detailBinding;


    // 1. 데이터를 전달 받아서 화면을 구성
    // 2. 여기서 통신 요청을 해서 화면을 구성성


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        detailBinding = ActivityMovieDetailBinding.inflate(getLayoutInflater());
        setContentView(detailBinding.getRoot());

        if (getIntent() != null) {
            movie = (Movie) getIntent().getSerializableExtra(Define.PARAM_NAME_1);
            // 얜 오브젝트로 넘어옴
            initData();
            addEventListener();
        }
    }

    private void initData() {
        detailBinding.titleTextView.setText(movie.getTitle());
        detailBinding.yearTextView.setText(" 제작 년도 : " + movie.getYear());
        detailBinding.runTimeTextView.setText(" 상영 시간 : " + movie.getRuntime() + "(min)");
        Glide.with(this).load(movie.getMediumCoverImg()).centerCrop().into(detailBinding.moviePoster);
        Glide.with(this).load(movie.getBackGroundImg()).into(detailBinding.backgroundImgView);


    }

    private void addEventListener() {

    }
}