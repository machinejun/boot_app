package com.example.myfragment;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;


public class FragmentTwo extends Fragment {
    private static final String TAG = "fragment1";

    // 실행 흐름이 있다 = life 사이클 존재


    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        Log.d(TAG,"onattach");
    }

    public FragmentTwo() {
        // Required empty public constructor
    }

    public static FragmentTwo newInstance() {
        FragmentTwo fragment = new FragmentTwo();

        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d(TAG,"onCreate() 호출");
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        Log.d(TAG,"onCreateView() 호출");
        return inflater.inflate(R.layout.fragment_two, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        Log.d(TAG,"onViewCreate() 호출");
    }

    @Override
    public void onViewStateRestored(@Nullable Bundle savedInstanceState) {
        super.onViewStateRestored(savedInstanceState);
        Log.d(TAG,"onViewCreateRestored() 호출");
    }

    @Override
    public void onStart() {
        super.onStart();
        Log.d(TAG,"onStart() 호출");
    }

    @Override
    public void onResume() {
        super.onResume();
        Log.d(TAG,"onResume() 호출");
    }

    @Override
    public void onPause() {
        super.onPause();
        Log.d(TAG,"onPause() 호출");
    }

    @Override
    public void onStop() {
        super.onStop();
        Log.d(TAG,"onStop() 호출");
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        Log.d(TAG,"onDestoryView() 호출");
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.d(TAG,"onDestory() 호출");
    }

    @Override
    public void onDetach() {
        super.onDetach();
        Log.d(TAG,"onDetach() 호출");
    }
}