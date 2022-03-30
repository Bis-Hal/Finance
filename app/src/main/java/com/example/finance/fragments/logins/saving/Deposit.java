package com.example.finance.fragments.logins.saving;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.finance.R;

import java.util.ArrayList;
import java.util.Date;
import java.util.SimpleTimeZone;

public class Deposit extends Fragment {

   private TextView date;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_deposit, container, false);

        date = view.findViewById(R.id.date);
        Date todayDate = new Date();
        date.setText(todayDate.toString());

        return view;
    }

}