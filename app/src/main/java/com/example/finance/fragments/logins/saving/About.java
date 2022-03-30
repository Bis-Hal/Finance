package com.example.finance.fragments.logins.saving;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.finance.R;


public class About extends Fragment {
    Intent intent;
    private TextView name;

    public About(Intent intent){
        this.intent = intent;
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_about, container, false);
        name = view.findViewById(R.id.r1c1);


        return view;
    }

}