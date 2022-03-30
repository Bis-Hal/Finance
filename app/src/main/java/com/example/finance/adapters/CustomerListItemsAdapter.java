package com.example.finance.adapters;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.finance.R;
import com.example.finance.Saving;
import com.example.finance.models.Customers;
import com.google.android.material.card.MaterialCardView;

import java.util.ArrayList;


public class CustomerListItemsAdapter extends RecyclerView.Adapter<CustomerListItemsAdapter.ViewHolder>{
    private Context context;
    private ArrayList<Customers> customers = new ArrayList<>();

    public CustomerListItemsAdapter() {
    }

    public CustomerListItemsAdapter(Context context) {
        this.context = context;
    }

    public void setCustomers(ArrayList<Customers> customers) {
        this.customers = customers;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.customer_list_items, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.serialno.setText(String.valueOf(customers.get(position).getCustomerID()));
        holder.customerName.setText(customers.get(position).getCustomerName());
        String num = "tel:" + customers.get(position).getContact();
        holder.callBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_CALL);
                intent.setData(Uri.parse(num));
                context.startActivity(intent);
            }
        });

        holder.parent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, Saving.class);
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return customers.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private TextView serialno, customerName;
        private ImageView callBtn;
        private MaterialCardView parent;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            serialno = itemView.findViewById(R.id.serialNo);
            customerName = itemView.findViewById(R.id.name);
            callBtn = itemView.findViewById(R.id.callBtn);
            parent = itemView.findViewById(R.id.parent);
        }
    }
}
