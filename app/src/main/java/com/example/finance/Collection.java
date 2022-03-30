package com.example.finance;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.viewpager2.widget.ViewPager2;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.finance.adapters.CustomerListItemsAdapter;
import com.example.finance.fragment.handler.FragmentHandler;
import com.example.finance.fragment.handler.ViewPageHandler;
import com.example.finance.fragments.logins.Login;
import com.example.finance.fragments.logins.SignUp;
import com.example.finance.fragments.logins.customer.status.ActiveCustomers;
import com.example.finance.fragments.logins.customer.status.AllCustomers;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.tabs.TabItem;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;

public class Collection extends AppCompatActivity {

    private ViewPager2 customersViewPage;
    private TabLayout customersStaus;
    private FloatingActionButton addCustomer;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_collection);

        customersViewPage = findViewById(R.id.customersViewPager);
        customersStaus = findViewById(R.id.customerStatus);
        addCustomer = findViewById(R.id.addCustomer);

        ArrayList<Fragment> fragments = new ArrayList<>();
        fragments.add(new ActiveCustomers());
        fragments.add(new AllCustomers());

        FragmentHandler fragmentHandler = new FragmentHandler();
        fragmentHandler.fragmentCreate(this, customersViewPage,fragments);

        ViewPageHandler viewPageHandler = new ViewPageHandler(customersViewPage, customersStaus);
    }

    @Override
    protected void onStart() {
        super.onStart();
    }
}