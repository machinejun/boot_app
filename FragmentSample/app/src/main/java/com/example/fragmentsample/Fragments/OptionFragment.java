package com.example.fragmentsample.Fragments;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.fragmentsample.R;

public class OptionFragment extends Fragment {
    //1 번 레이아웃
    TextView showProfile;
    //2 번 레이아웃
    LinearLayout sellHistory;
    LinearLayout buyHistory;
    LinearLayout favoiteList;
    //3 번 레이아웃
    LinearLayout setMyhome;
    LinearLayout cetifyMyhome;
    LinearLayout noteKeyWord;
    LinearLayout collection;


    ViewGroup viewGroup;
    OptionEventListener callback;

    public interface OptionEventListener {
        void optionCilck(int id);
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        viewGroup = (ViewGroup) inflater.inflate(R.layout.fragment_option, container, false);
        getOptionId();
        setOptionEvent();
        return viewGroup;
    }

    private void setOptionEvent() {
        showProfile.setOnClickListener(view -> {
            callback.optionCilck(showProfile.getId());
        });
        buyHistory.setOnClickListener(view -> {
            callback.optionCilck(buyHistory.getId());
        });
        sellHistory.setOnClickListener(view -> {
            callback.optionCilck(sellHistory.getId());
        });
        favoiteList.setOnClickListener(view -> {
            callback.optionCilck(favoiteList.getId());
        });
        setMyhome.setOnClickListener(view -> {
            callback.optionCilck(setMyhome.getId());
        });
        cetifyMyhome.setOnClickListener(view -> {
            callback.optionCilck(cetifyMyhome.getId());
        });
        noteKeyWord.setOnClickListener(view -> {
            callback.optionCilck(noteKeyWord.getId());
        });
        collection.setOnClickListener(view -> {
            callback.optionCilck(noteKeyWord.getId());
        });
    }

    private void getOptionId() {
        showProfile = viewGroup.findViewById(R.id.showProfile);
        //
        buyHistory = viewGroup.findViewById(R.id.buyHistory);
        sellHistory = viewGroup.findViewById(R.id.saleHistory);
        favoiteList = viewGroup.findViewById(R.id.favorite);
        //
        setMyhome = viewGroup.findViewById(R.id.setMyhome);
        cetifyMyhome = viewGroup.findViewById(R.id.certifyMyhome);
        noteKeyWord = viewGroup.findViewById(R.id.noteKeword);
        collection = viewGroup.findViewById(R.id.collection);

    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        if (context instanceof OptionEventListener) {
            callback = (OptionEventListener) context;
        }

    }
}