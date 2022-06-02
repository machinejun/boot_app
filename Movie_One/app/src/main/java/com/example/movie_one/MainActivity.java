package com.example.movie_one;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;

import com.example.movie_one.databinding.ActivityMainBinding;
import com.example.movie_one.utils.FragmentType;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // 바인딩 객체 초기화
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        // 연결
        setContentView(binding.getRoot());
        // 사용
        replacefragment(FragmentType.MOVIE);// 초기 프래그먼트를 Movie 로 설정한다.
        addBottomNavigationListener(); // 바텀바의 이벤트를 등록
    }
    private void addBottomNavigationListener(){
        binding.bottomNavigation.setOnItemSelectedListener( item -> {
            switch (item.getItemId()){
                case R.id.page1:
                    replacefragment(FragmentType.MOVIE);
                    break;
                case  R.id.page2:
                    replacefragment(FragmentType.INFO);
            }
            return true;
        });
    }

    private void replacefragment(FragmentType type){
        Fragment fragment = null;
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        if(type == FragmentType.MOVIE){
            fragment = new MovieFragment(); // MOVIE tag
        }else{
            fragment = new InfoFragment(); // INFO tag
        }
        transaction.replace(binding.mainContainer.getId(),fragment, type.toString());
        transaction.commit();

    }
}