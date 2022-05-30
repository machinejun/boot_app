package com.example.myretrofit;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.LinearGradient;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.example.myretrofit.repository.models.RetrofitService;
import com.example.myretrofit.repository.models.Todo;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {
    TextView textView;

    Retrofit retrofit;
    RetrofitService service;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /*
            retrofit 객체 초기화
            빌더 패턴 >> 객체를 생성할 때 사용 하는 디자인 패턴, 순서 상관 x , 매개변수 갯수 각각 조절
            baseUrl 사용시 마지막에 반드시 / 를 해주어야 한다.

         */
        textView = findViewById(R.id.temp);
        retrofit = new Retrofit.Builder()
                .baseUrl("https://jsonplaceholder.typicode.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        // 비지니스 로직
        // todo 데이터를 들고 오는 것
        // post 데이터를 들고 오는 것
        // users 데이터를 들고 오는 것

        // 초기화된 레트로핏 오브젝트와 비지니스 로직인 인터페이스를 연결

        service = retrofit.create(RetrofitService.class); // 메모리에 올리는 과정
        service.getTodos().enqueue(new Callback<ArrayList<Todo>>() {
            @Override
            public void onResponse(Call<ArrayList<Todo>> call, Response<ArrayList<Todo>> response) {
                Log.d("TAG", response.isSuccessful() + "<---");
                Log.d("TAG", response.message());
                if(response.isSuccessful()){
                    // 타입변화 코드를 넣지 않아도 된다.
                    Todo todo = response.body().get(0);
                    Log.d("TAG","title : " + todo.toString());
                    textView.setText(todo.id + "");

                }
            }

            @Override
            public void onFailure(Call<ArrayList<Todo>> call, Throwable t) {
                Log.d("TAG","실패: " + t.getMessage());
            }
        }); // 비동기방식으로 통신을 한다.




    }
}