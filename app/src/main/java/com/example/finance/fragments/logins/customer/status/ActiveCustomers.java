package com.example.finance.fragments.logins.customer.status;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.finance.R;
import com.example.finance.adapters.CustomerListItemsAdapter;
import com.example.finance.models.Customers;

import java.util.ArrayList;

public class ActiveCustomers extends Fragment {
     private RecyclerView activeCustomerRecyclerView, getActiveCustomerRecyclerViewLand;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_active_customers, container, false);

        activeCustomerRecyclerView = view.findViewById(R.id.activeCustomers);
        getActiveCustomerRecyclerViewLand = view.findViewById(R.id.activeCustomersLand);

        ArrayList<Customers> addCustomers = new ArrayList<>();
        addCustomers.add(new Customers(1,"Bishal Maharjan","Kathmandu","9818496135"));
        addCustomers.add(new Customers(2,"Siwa Chand","Kathmandu","9843807589"));
        addCustomers.add(new Customers(3,"Chiwa Chand","Kathmandu","9823838109"));
        addCustomers.add(new Customers(4,"Aayush Maharjan","Kathmandu","9860930488"));
        addCustomers.add(new Customers(5,"Bal Krishna Maharjan","Kathmandu","9841759686"));
        addCustomers.add(new Customers(6,"Laxmi Maharjan","Kathmandu","9861444981"));

        CustomerListItemsAdapter customerListItemsAdapter = new CustomerListItemsAdapter(getContext());
        customerListItemsAdapter.setCustomers(addCustomers);




        if(activeCustomerRecyclerView!= null){
            activeCustomerRecyclerView.setAdapter(customerListItemsAdapter);
            activeCustomerRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        }
        else{
            getActiveCustomerRecyclerViewLand.setAdapter(customerListItemsAdapter);
            getActiveCustomerRecyclerViewLand.setLayoutManager(new GridLayoutManager(getContext(), 2));
        }
        return view;
    }
}