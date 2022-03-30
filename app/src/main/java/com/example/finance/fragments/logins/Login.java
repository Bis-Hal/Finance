package com.example.finance.fragments.logins;

import static android.text.InputType.TYPE_CLASS_TEXT;
import static android.text.InputType.TYPE_TEXT_VARIATION_PASSWORD;
import static android.text.InputType.TYPE_TEXT_VARIATION_PERSON_NAME;
import static android.text.InputType.TYPE_TEXT_VARIATION_VISIBLE_PASSWORD;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.finance.HomePage;
import com.example.finance.R;
import com.example.finance.database.Connection;
import com.example.finance.validation.LoginValidation;
import com.google.android.material.card.MaterialCardView;


public class Login extends Fragment {

    private MaterialCardView materialCardView;
    private EditText passwordInput;
    private ImageView show, hide;
    private View view;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_login, container, false);

        materialCardView = view.findViewById(R.id.loginButton);
        passwordInput = view.findViewById(R.id.passwordInput);

        show = view.findViewById(R.id.show);
        hide = view.findViewById(R.id.hide);
        Connection connection = new Connection(getContext());



        return view;
    }

    @Override
    public void onStart() {
        super.onStart();
    }

    @Override
    public void onResume() {
        super.onResume();
        LoginValidation loginValidation = new LoginValidation(view, getContext());

        materialCardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!loginValidation.validation()) {
//                    Toast.makeText(getContext(), R.string.failed, Toast.LENGTH_SHORT).show();
                    System.out.println("failed");
                }
                else {
                    Intent intent = new Intent(getContext(), HomePage.class);
                    startActivity(intent);
                }
            }
        });
        hide.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                passwordInput.setInputType(TYPE_TEXT_VARIATION_PASSWORD);
                show.setVisibility(View.VISIBLE);
                hide.setVisibility(View.GONE);
                Toast.makeText(getContext(),"hide", Toast.LENGTH_SHORT).show();
            }
        });

        show.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                passwordInput.setInputType(TYPE_CLASS_TEXT);
                hide.setVisibility(View.VISIBLE);
                show.setVisibility(View.GONE);
                Toast.makeText(getContext(),"show", Toast.LENGTH_SHORT).show();
            }
        });


    }
}