package com.example.myfragment;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.widget.Button;
import android.widget.LinearLayout;

public class HomeActivity extends AppCompatActivity {

    private FragmentBanner fragmentBanner;
    private Button btnCreate;
    private Button btnDelete;
    private LinearLayout container;

    private FragmentOne fragmentOne;
    private Button btnCreate2;
    private Button btnDelete2;
    private LinearLayout container2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        btnCreate = findViewById(R.id.btnCreate);
        btnDelete = findViewById(R.id.btnDelete);
        container = findViewById(R.id.container);

        // 프래그먼트 생성
        btnCreate.setOnClickListener(view -> {
            fragmentBanner = new FragmentBanner();
            /*
                플래그먼트를 동적으로 만들기 위해서 필요한 것
                1. fragmentManager 필요( fragment 트랜잭션 객체를 가져올 수 있다. )
                2. fragmentTransaction ()
                >> transaction : 하나의 작업의 단위(여러개의 작업들을 묶어서 하나의 작업단위로 만듬)
                               : 시작과 끝이 있다.
             */
            FragmentManager manager = getSupportFragmentManager();
            FragmentTransaction transaction = manager.beginTransaction(); // 지금부터 트랜잭션 처리를 시작한다.
            // 실행  >> xml 파일에 만들어둔 영역 (view component에 올린다.)
            transaction.replace(R.id.container, fragmentBanner);
            transaction.commit(); // 시간이 될 때 완료 시켜라 (권장)
//            transaction.commitNow(); // 지금 당장 실행 시켜라!!!
//            transaction.commitAllowingStateLoss(); // 위험( 커밋이 없어질 수 있다. ) -- 쓸일이 없다 사용 ㄴㄴ
        });

        // 프레그먼트 제거
        btnDelete.setOnClickListener(view -> {
            //remove
            FragmentManager manager = getSupportFragmentManager();
            FragmentTransaction transaction = manager.beginTransaction();
            //transaction.remove(fragmentBanner);
            transaction.detach(fragmentBanner);
            transaction.commit();
        });




    }
}