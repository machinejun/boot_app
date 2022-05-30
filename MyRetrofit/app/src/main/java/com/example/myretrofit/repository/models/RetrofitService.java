package com.example.myretrofit.repository.models;


// 모델 분리
// 비즈니스 로직을 처리하는 부분을 분리

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.http.GET;

public interface RetrofitService {

    //https://jsonplaceholder.typicode.com/todos
    @GET("todos")
    Call<ArrayList<Todo>> getTodos();


}
