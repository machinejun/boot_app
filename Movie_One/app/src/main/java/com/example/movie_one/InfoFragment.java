package com.example.movie_one;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Bitmap;
import android.os.Bundle;

import androidx.activity.OnBackPressedCallback;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.example.movie_one.databinding.FragmentInfoBinding;
import com.example.movie_one.interfaces.OnPassWebView;
import com.example.movie_one.interfaces.ToolbarChanged;
import com.example.movie_one.utils.Define;

public class InfoFragment extends Fragment {
    private static InfoFragment instance;
    private FragmentInfoBinding infoBinding;
    private ToolbarChanged callback;
    private WebView webView;
    private OnPassWebView onPassWebView;


    public void setOnPassWebView(OnPassWebView onPassWebView) {
        this.onPassWebView = onPassWebView;
    }

    private InfoFragment(ToolbarChanged callback) {
        this.callback = callback;
    }

    @SuppressLint("SetJavaScriptEnabled")
    private void setupWebView(){
        webView = infoBinding.webView;
        webView.loadUrl("https://yts.mx/");
        webView.setWebViewClient(new WebViewClient() {
            @Override
            public void onPageStarted(WebView view, String url, Bitmap favicon) {
                super.onPageStarted(view, url, favicon);
                // 페이지가 첨을 로드될때 콜백
            }

            @Override
            public void onPageFinished(WebView view, String url) {
                super.onPageFinished(view, url);
                //렌더링이 완료된 후에 콜백된다.
                infoBinding.progressIndicator.setVisibility(View.GONE);
            }
        });
        // 자바 스크립트 허용하는 코드를 넣어주어야 한다. 안하면 뒤로가기 하면 webview에서 나온다.
        WebSettings webSettings = webView.getSettings();
        webSettings.setJavaScriptEnabled(true);
        onPassWebView.onPassWebViewObj(webView);
    }

    public static InfoFragment getInstance(ToolbarChanged callback) {
        if(instance == null){
            instance = new InfoFragment(callback);
        }
        return instance;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        callback.changeTitle(Define.SECOND_TITLE);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        infoBinding = FragmentInfoBinding.inflate(inflater, container, false);
        // 뷰 결합하기 위해서 메모리 초기화
        setupWebView();

        return infoBinding.getRoot();
    }

}