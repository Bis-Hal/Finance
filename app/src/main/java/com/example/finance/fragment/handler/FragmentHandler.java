package com.example.finance.fragment.handler;

import android.content.Context;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.viewpager2.widget.ViewPager2;

import com.example.finance.SignIn;
import com.example.finance.adapters.ViewPageAdapter;
import com.example.finance.fragments.logins.Login;
import com.example.finance.fragments.logins.SignUp;

import java.util.ArrayList;

public class FragmentHandler {
    public  void fragmentCreate(FragmentActivity fragmentActivity, ViewPager2 viewPager2,ArrayList<Fragment> fragments){
        FragmentManager fragmentManager = fragmentActivity.getSupportFragmentManager();
        ViewPageAdapter viewPageAdapter = new ViewPageAdapter(fragmentManager,fragmentActivity.getLifecycle());
        viewPageAdapter.setFragments(fragments);
        viewPager2.setAdapter(viewPageAdapter);
    }
}
