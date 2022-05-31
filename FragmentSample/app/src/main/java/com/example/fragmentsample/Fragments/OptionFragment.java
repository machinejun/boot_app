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
    TextView showProfile;
    LinearLayout sellHistory;
    LinearLayout buyHistory;
    LinearLayout favoiteList;
    ViewGroup viewGroup;
    OptionEventListener callback;

    public interface OptionEventListener{
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
    }

    private void getOptionId() {
        showProfile = viewGroup.findViewById(R.id.showProfile);
        buyHistory = viewGroup.findViewById(R.id.buyHistory);
        sellHistory = viewGroup.findViewById(R.id.saleHistory);
        favoiteList = viewGroup.findViewById(R.id.favorite);

    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        if(context instanceof OptionEventListener){
            callback = (OptionEventListener) context;
        }

    }
}