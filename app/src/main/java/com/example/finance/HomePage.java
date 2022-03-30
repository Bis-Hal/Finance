package com.example.finance;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.finance.adapters.HomePageItemsAdapter;
import com.example.finance.models.HomePageItems;

import java.util.ArrayList;

public class HomePage extends AppCompatActivity {

    private RecyclerView recyclerView,recyclerViewHorizontal;
    private ImageView logout;
    private ArrayList<HomePageItems> items = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);

        recyclerView = findViewById(R.id.recyclerViewItems);
        recyclerViewHorizontal = findViewById(R.id.recyclerViewItemsHorizontal);
        logout = findViewById(R.id.logout);


        if(recyclerViewHorizontal!= null) {
            addItemsRecyclerView(recyclerViewHorizontal, 4);
        }else{
            addItemsRecyclerView(recyclerView, 2);
        }
    }
    public void addItemsRecyclerView(RecyclerView recyclerView, int spanCount){
        items.add(new HomePageItems(getString(R.string.daily_saving),R.drawable.collection));
        items.add(new HomePageItems(getString(R.string.bal_bachat),R.drawable.record));
        items.add(new HomePageItems(getString(R.string.jestha_nagarik_bachat),R.drawable.signature));
        items.add(new HomePageItems(getString(R.string.special_saving),R.drawable.bank));
        items.add(new HomePageItems(getString(R.string.bank),R.drawable.voucher));
        items.add(new HomePageItems(getString(R.string.cheque_deposit),R.drawable.cheque));

        HomePageItemsAdapter homePageItemsAdapter = new HomePageItemsAdapter(this);
        homePageItemsAdapter.setHomePageItems(items);

        recyclerView.setAdapter(homePageItemsAdapter);
        recyclerView.setLayoutManager(new GridLayoutManager(this,spanCount));

    }

    @Override
    protected void onResume() {
        super.onResume();
        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(HomePage.this, SignIn.class );
                startActivity(intent);
                Toast.makeText(HomePage.this, R.string.logged_out, Toast.LENGTH_SHORT).show();
            }
        });
    }
}