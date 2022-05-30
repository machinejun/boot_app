package com.example.retrofit2.repository.service;

import com.example.retrofit2.repository.models.Post;
import com.example.retrofit2.repository.models.Todo;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Part;
import retrofit2.http.Path;

public interface RetrofitService {

    @GET("todos")
    Call<ArrayList<Todo>> getTodos();

    @GET("todos/{id}")
    Call<Todo> getTodo(@Path("id") int id);

    // 모바일 --> 서버에 내 정보를 데이터 베이스에 입력 요청 !!
    @FormUrlEncoded
    @POST("posts")
    Call<Post> createPosts(
            @Field("userId") int userId,
            @Field("id") int id,
            @Field("title") String title,
            @Field("body") String body
    );


}
