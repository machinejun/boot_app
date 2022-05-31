package com.example.retrofit3;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.Toast;

import com.example.retrofit3.Service.JPHService;
import com.example.retrofit3.models.request.RequestPostDto;
import com.example.retrofit3.models.response.ResponsePostDto;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";

    /*
        0. retrofit implement
        1. path 설계 >> JPH service + request,response Dto 설계
        2. xml 그리기
        3. 통신 테스트
        4. 이벤트 처리
     */
    private JPHService service;

    private Button btn1;
    private Button btn2;
    private Button btn3;
    private Button btn4;
    private Button btn5;
    private Button btn6;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initData();
        addEventListener();
    }

    private void initData() {
        service = JPHService.retrofit.create(JPHService.class);
        btn1 = findViewById(R.id.btn1);
        btn2 = findViewById(R.id.btn2);
        btn3 = findViewById(R.id.btn3);
        btn4 = findViewById(R.id.btn4);
        btn5 = findViewById(R.id.btn5);
        btn6 = findViewById(R.id.btn6);
    }

    private void addEventListener() {
        btn1.setOnClickListener(view -> {
            Log.d("TAG","btn1 click");
            service.post(10).enqueue(new Callback<ResponsePostDto>() {
                @Override
                public void onResponse(Call<ResponsePostDto> call, Response<ResponsePostDto> response) {
                    if(response.isSuccessful()){
                        // 자동 파싱 Json -> object 로 변환 처리
                        ResponsePostDto responsePostDto = response.body();
                        Log.d(TAG, responsePostDto + "");
                    }
                }

                @Override
                public void onFailure(Call<ResponsePostDto> call, Throwable t) {

                }
            });
        });
        btn2.setOnClickListener(view -> {
            Log.d("TAG","btn2 click");
            service.postList().enqueue(new Callback<List<ResponsePostDto>>() {
                @Override
                public void onResponse(Call<List<ResponsePostDto>> call, Response<List<ResponsePostDto>> response) {
                    Log.d(TAG,response.code() + "<--- code");
                    ArrayList<ResponsePostDto> list = (ArrayList<ResponsePostDto>) response.body();
                    Log.d(TAG, list.toString());
                }

                @Override
                public void onFailure(Call<List<ResponsePostDto>> call, Throwable t) {

                }
            });

        });
        btn3.setOnClickListener(view -> {
            /*
                로그인 ( userId --> 쉐어드프리퍼런스에 저장 )
                                    , (SQL Lite 에서 꺼내서 사용한다)
                                    , 메모리 스태틱 변수로 사용하기도 한다.
             */
            Log.d("TAG","btn3 click");
            service.createPost(new RequestPostDto("회의","db설계회의", 10)).enqueue(new Callback<ResponsePostDto>() {
                @Override
                public void onResponse(Call<ResponsePostDto> call, Response<ResponsePostDto> response) {
                    if(response.isSuccessful()){
                        Toast.makeText(MainActivity.this, "저장 성공",Toast.LENGTH_SHORT).show();
                        Log.d(TAG,response.body().toString());
                    } else {
                        Toast.makeText(MainActivity.this, "저장 실패",Toast.LENGTH_SHORT).show();
                    }
                }

                @Override
                public void onFailure(Call<ResponsePostDto> call, Throwable t) {
                    Log.d(TAG, t.toString());
                }
            });
        });
        btn4.setOnClickListener(view -> {
            Log.d("TAG","btn4 click");
            service.updatePost(10, new RequestPostDto("오전 10:25","햇빗이 따사롭다", 20))
                    .enqueue(new Callback<ResponsePostDto>() {
                @Override
                public void onResponse(Call<ResponsePostDto> call, Response<ResponsePostDto> response) {
                    if(response.isSuccessful()){
                        Log.d(TAG, response.body().toString());
                    }else{
                        Log.d(TAG, "수정 실패");
                    }
                }

                @Override
                public void onFailure(Call<ResponsePostDto> call, Throwable t) {

                }
            });
        });
        btn5.setOnClickListener(view -> {
            Log.d("TAG","btn5 click");
            service.deletePost(10).enqueue(new Callback<Void>() {
                @Override
                public void onResponse(Call<Void> call, Response<Void> response) {
                    if (response.isSuccessful()){
                        Log.d(TAG, "success");
                        //Log.d(TAG, response.body().toString());
                    }
                }

                @Override
                public void onFailure(Call<Void> call, Throwable t) {

                }
            });
        });
        btn6.setOnClickListener(view -> {
            Log.d("TAG","btn6 click");
            service.searchByUserId(0).enqueue(new Callback<List<ResponsePostDto>>() {
                @Override
                public void onResponse(Call<List<ResponsePostDto>> call, Response<List<ResponsePostDto>> response) {
                    if(response.isSuccessful()){
                        Log.d(TAG,"network success");
                        ArrayList<ResponsePostDto> list = (ArrayList<ResponsePostDto>) response.body();
                        Log.d(TAG, list.toString());
                    }
                }

                @Override
                public void onFailure(Call<List<ResponsePostDto>> call, Throwable t) {

                }
            });
        });
    }
}