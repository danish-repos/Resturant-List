package com.example.resturants;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


// custom adapter for the row_layout
// custom design for every item in the list

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {

    private ArrayList<Restaurant> restaurantsList ;

    public MyAdapter(Context context, ArrayList<Restaurant> restaurantsList) {
        this.restaurantsList = restaurantsList;
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        // making a view and inflating it to out custom design
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_layout, parent, false);
        return new ViewHolder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        holder.itemView.setTag(restaurantsList.get(position));

        holder.tvName.setText(restaurantsList.get(position).getName());
        holder.tvLocation.setText(restaurantsList.get(position).getLocation());
        holder.tvPhoneNumber.setText(restaurantsList.get(position).getPhoneNumber());
        holder.tvDescription.setText(restaurantsList.get(position).getDescription());
        holder.tvRatings.setText(restaurantsList.get(position).getRating()+ "");

    }

    @Override
    public int getItemCount() {
        return restaurantsList.size();
    }


    // making our own view holder class
    // that holds the view

    public static class ViewHolder extends RecyclerView.ViewHolder{

        TextView tvName, tvLocation, tvPhoneNumber, tvDescription, tvRatings;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            tvName = itemView.findViewById(R.id.tvName);
            tvLocation = itemView.findViewById(R.id.tvLocation);
            tvPhoneNumber = itemView.findViewById(R.id.tvPhoneNumber);
            tvDescription = itemView.findViewById(R.id.tvDescription);
            tvRatings = itemView.findViewById(R.id.tvRatings);

        }
    }

}
