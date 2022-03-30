package com.example.finance;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.viewpager2.widget.ViewPager2;

import android.content.Intent;
import android.os.Bundle;

import com.example.finance.fragment.handler.FragmentHandler;
import com.example.finance.fragment.handler.ViewPageHandler;
import com.example.finance.fragments.logins.saving.About;
import com.example.finance.fragments.logins.saving.Deposit;
import com.example.finance.fragments.logins.saving.History;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;

public class Saving extends AppCompatActivity {

    private ViewPager2 viewPager2;
    private TabLayout tabLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_saving);

        viewPager2 = findViewById(R.id.savingViewPager);
        tabLayout = findViewById(R.id.savingTabLayout);

        Intent intent = getIntent();

        ArrayList<Fragment> fragments = new ArrayList<>();
        fragments.add(new Deposit());
        fragments.add(new History());
        fragments.add(new About(intent));



        FragmentHandler fragmentHandler = new FragmentHandler();
        fragmentHandler.fragmentCreate(this, viewPager2, fragments);

        ViewPageHandler viewPageHandler = new ViewPageHandler(viewPager2, tabLayout);

    }
}