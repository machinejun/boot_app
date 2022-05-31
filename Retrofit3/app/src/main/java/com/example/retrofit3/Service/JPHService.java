package com.example.retrofit3.Service;

import com.example.retrofit3.models.request.RequestPostDto;
import com.example.retrofit3.models.response.ResponsePostDto;

import java.util.List;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;

public interface JPHService {
    // https://jsonplaceholder.typicode.com/

    // 레트로핏 초기화
    /*
        빌더 패턴 : 복합 객체의 생성과정과 표현 방법을 분리하여 동일 한
                    생성절차에서 서로 다른 결과를 만들수 있게 해주는 패턴이다.
        >> 장점
        1. 필요한 데이터만 설정할 수 있음
        2. 유연성을 확보할수 있음
        3. 가독성을 높일 수 있음
        4. 변경 가능성을 최소화 할 수 있음
     */
    Retrofit retrofit = new Retrofit.Builder()
            .baseUrl("https://jsonplaceholder.typicode.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build();


    // 1개만 받기
    @GET("posts/{id}")
    Call<ResponsePostDto> post(@Path("id") int id);

    // 전체 받기
    @GET("posts")
    Call<List<ResponsePostDto>> postList();

    // Http 메세지 바디 부분에 데이터를 넣어서 서버에 전송
    // Mime Type = json type
    // 데이터가 잘 전송 되었다면 응답값을 보내 준다.
    // 매개변수로 데이터를 전송
    // 값을 전송할 때 어떻게 데이터를 전송할지 설계해야 한다. >> requestDto 설계
    @POST("posts")
    Call<ResponsePostDto> createPost(@Body RequestPostDto postDto);

    @PUT("posts/{postId}")
    Call<ResponsePostDto> updatePost(@Path("postId") int postId, @Body RequestPostDto putDto);

    @DELETE("posts/{postId}")
    Call<Void> deletePost(@Path("postId") int postId);

    @FormUrlEncoded  // @Field를 사용해야한다.,
    @POST("/posts")
    Call<List<ResponsePostDto>> searchByUserId(@Field("userId") int id);
}
