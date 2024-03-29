package com.example.resturants;

import static java.util.Locale.filter;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.SearchView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Locale;


// this is the main activity that runs at the start
public class MainActivity extends AppCompatActivity {


    Button btnAdd;

    SearchView svRestaurant;
    RecyclerView rvList;
    RecyclerView.LayoutManager layoutManager;
    public static MyAdapter myAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });


        init();

        // it will tells us whenever the text has been submit
        // in the search view
        svRestaurant.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                filter(newText);
                return false;
            }
        });


        // on clicking the add button
        // it goes to the "Add" screen where you can add new restaurants
        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity(new Intent(MainActivity.this, addRestaurant.class));

            }
        });

    }

    private void init() {
        btnAdd = findViewById(R.id.btnAdd);
        svRestaurant = findViewById(R.id.svRestaurtant);

        rvList = findViewById(R.id.rvList);
        rvList.setHasFixedSize(true);

        layoutManager = new LinearLayoutManager(getApplicationContext());
        rvList.setLayoutManager(layoutManager);


        // sorting the list on the ratings before showing it
        MyApplication.restaurants.sort(new Comparator<Restaurant>() {
            @Override
            public int compare(Restaurant o1, Restaurant o2) {
                return Double.compare(o2.getRating(), o1.getRating());
            }
        });

        // setting up the custom adapter
        myAdapter = new MyAdapter(this, MyApplication.restaurants);
        rvList.setAdapter(myAdapter);

    }


    // filtering the list according to the search of the user
    private void filter(String text) {

        ArrayList<Restaurant> searchFiltered = new ArrayList<>();

        for (Restaurant restaurant : MyApplication.restaurants) {

            if (restaurant.getName().toLowerCase().contains(text.toLowerCase())) {
                searchFiltered.add(restaurant);
            }
        }

        // sorting it by the rating
        // highest rated will be the first to appear

        searchFiltered.sort(new Comparator<Restaurant>() {
            @Override
            public int compare(Restaurant o1, Restaurant o2) {
                return Double.compare(o2.getRating(), o1.getRating());
            }
        });


        myAdapter.filterList(searchFiltered);
    }
}
