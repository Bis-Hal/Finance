package com.example.finance.adapters;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.finance.Collection;
import com.example.finance.R;
import com.example.finance.Saving;
import com.example.finance.models.HomePageItems;
import com.google.android.material.card.MaterialCardView;

import java.util.ArrayList;

public class HomePageItemsAdapter extends RecyclerView.Adapter<HomePageItemsAdapter.ViewHolder> {

    private ArrayList<HomePageItems> homePageItems = new ArrayList<>();
    private Context context;

    public HomePageItemsAdapter(Context context) {
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
       View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.home_page_items, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.itemImage.setImageResource(homePageItems.get(position).getItem_images());
        holder.itemLabel.setText(homePageItems.get(position).getItem_name());

        holder.parent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                switch (holder.getAdapterPosition()){
                    case 0:{
                        Intent intent = new Intent(context, Collection.class);
                        context.startActivity(intent);
                        break;
                    }
                    case 1:{
                        Toast.makeText(context, "second", Toast.LENGTH_SHORT).show();
                        break;
                    }
                    case 2:{
                        Toast.makeText(context, "third", Toast.LENGTH_SHORT).show();
                        break;
                    }
                    case 3:{
                        Toast.makeText(context, "forth", Toast.LENGTH_SHORT).show();
                        break;
                    }
                    default:{
                        Toast.makeText(context, "fifth", Toast.LENGTH_SHORT).show();
                        break;
                    }
                }

            }
        });
    }


    @Override
    public int getItemCount() {
        return homePageItems.size();
    }

    public void setHomePageItems(ArrayList<HomePageItems> homePageItems) {
        this.homePageItems = homePageItems;
        notifyDataSetChanged();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        private MaterialCardView parent;
        private ImageView itemImage;
        private TextView itemLabel;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            parent = itemView.findViewById(R.id.parent);
            itemImage = itemView.findViewById(R.id.itemImage);
            itemLabel = itemView.findViewById(R.id.itemLabel);
        }
    }
}
