package com.example.movie_one;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.webkit.WebView;

import com.example.movie_one.databinding.ActivityMainBinding;
import com.example.movie_one.interfaces.OnPassWebView;
import com.example.movie_one.interfaces.ToolbarChanged;
import com.example.movie_one.utils.Define;
import com.example.movie_one.utils.FragmentType;

public class MainActivity extends AppCompatActivity implements ToolbarChanged , OnPassWebView {

    private ActivityMainBinding binding;
    WebView webView; // InfoFragment 생성하는 WebView 객체 주소를 전달 받을 거다.

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
            fragment = MovieFragment.getinstance(this); // MOVIE tag
        }else{
            fragment = InfoFragment.getInstance(this); // INFO tag
            if(fragment != null){
                InfoFragment infoFragment = (InfoFragment) fragment;
                infoFragment.setOnPassWebView(this);
            }
        }
        transaction.replace(binding.mainContainer.getId(),fragment, type.toString());
        transaction.commit();
    }

    /**
     * 뒤로가기 버튼을 눌렀을 때 일어나는 이벤트 처리
     */
    @Override
    public void onBackPressed() {
        // 인포 프레그 먼트라면 한번은 무비 플래그 먼트로 갔다가 --> 무비 플래그 먼트면 원래대로 종료
        String fragmentTag = getSupportFragmentManager().findFragmentByTag(FragmentType.INFO.toString()).getTag();
        if(fragmentTag.equals(FragmentType.INFO.toString())){
            if(webView.canGoBack()){
                webView.goBack();
            }else{
                binding.bottomNavigation.setSelectedItemId(R.id.page1);
            }
        }else{
            super.onBackPressed();
        }
    }

    @Override
    public void changeTitle(String title) {
        binding.topAppBar.setTitle(title);

    }

    @Override
    public void onPassWebViewObj(WebView webView) {
        this.webView = webView;
    }
}