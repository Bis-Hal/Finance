package com.example.finance;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.viewpager2.widget.ViewPager2;

import android.os.Bundle;

import com.example.finance.adapters.ViewPageAdapter;
import com.example.finance.fragment.handler.FragmentHandler;
import com.example.finance.fragment.handler.ViewPageHandler;
import com.example.finance.fragments.logins.Login;
import com.example.finance.fragments.logins.SignUp;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;

public class SignIn extends AppCompatActivity {

    private ViewPager2 signInViewPager;
    private TabLayout signInTabLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signin);

        signInViewPager = findViewById(R.id.signInViewPager);
        signInTabLayout = findViewById(R.id.signInTabLayout);

        FragmentHandler fragmentHandler = new FragmentHandler();
        ArrayList<Fragment> fragments = new ArrayList<>();
        fragments.add(new Login());
        fragments.add(new SignUp());
        fragmentHandler.fragmentCreate(this, signInViewPager,fragments);
    }

    @Override
    protected void onStart() {
        super.onStart();
        ViewPageHandler viewPageHandler = new ViewPageHandler(signInViewPager, signInTabLayout);
    }
}