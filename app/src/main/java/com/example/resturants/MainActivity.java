package com.example.resturants;

import static java.util.Locale.filter;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.renderscript.Type;
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

    ArrayList<Restaurant> restaurants;

    Button btnAdd;
    SearchView svRestaurant;
    RecyclerView rvList;
    RecyclerView.LayoutManager layoutManager;
    public static MyAdapter myAdapter;


    SharedPreferences spref;
    private final String name = "RESTAURANT_SPREF";


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

        // it will tells us whenever the text has been submit in the search view
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


        // on clicking the add button, it goes to the "Add" screen where you can add new restaurants
        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity(new Intent(MainActivity.this, addRestaurant.class));

            }
        });

    }


    // initializing all the variables
    private void init() {
        btnAdd = findViewById(R.id.btnAdd);
        svRestaurant = findViewById(R.id.svRestaurtant);

        rvList = findViewById(R.id.rvList);
        rvList.setHasFixedSize(true);

        layoutManager = new LinearLayoutManager(getApplicationContext());
        rvList.setLayoutManager(layoutManager);

        spref = getSharedPreferences(name, MODE_PRIVATE);
        populateTheSpref();

        restaurants = getRestaurantListFromSharedPreferences();
        sortByRating(restaurants);

        // setting up the custom adapter
        myAdapter = new MyAdapter(this, restaurants);
        rvList.setAdapter(myAdapter);

    }


    // populating the spref with some random data
    private void populateTheSpref(){

        String temp = spref.getString("restaurant_list", null);
        if (temp != null)
            return;

        SharedPreferences.Editor editor = spref.edit();
        String[] restaurantData = {
                "Daily Deli Co,Model Town,1,Dive-In or Takeaway,2.3",
                "KFC,Wapda Town,2,A fast food place,4.3",
                "Pizza Online,PIA Road,3,Cash Only,4.2",
                "Johnny and Jugnu,Johar Town,4,Wraps,3.9\n",

        };

        String restaurantsString = String.join("\n", restaurantData);

        editor.putString("restaurant_list", restaurantsString);
        editor.apply();

    }


    // filtering the list according to the search of the user
    private void filter(String text) {

        ArrayList<Restaurant> searchFiltered = new ArrayList<>();

        for (Restaurant i : restaurants) {

            if (i.getName().toLowerCase().contains(text.toLowerCase())) {
                searchFiltered.add(i);
            }
        }

        sortByRating(searchFiltered);
        myAdapter.filterList(searchFiltered);
    }


    private void sortByRating(ArrayList<Restaurant> restaurants){
        Collections.sort(restaurants, new Comparator<Restaurant>() {
            @Override
            public int compare(Restaurant o1, Restaurant o2) {
                return Double.compare(Double.parseDouble(o2.getRating()),Double.parseDouble(o1.getRating()));
            }
        });


    }


    // returns the array by taking the data from the spref
    private ArrayList<Restaurant> getRestaurantListFromSharedPreferences() {

        ArrayList<Restaurant> restaurantList = new ArrayList<>();

        String restaurantsString = spref.getString("restaurant_list", null);

        if (restaurantsString != null) {
            String[] allRes = restaurantsString.split("\n");

            for (String res : allRes) {
                String[] split = res.split(",");
                if (split.length == 5) {
                    restaurantList.add(new Restaurant(split[0], split[1], split[2], split[3], split[4]));
                }
            }
        }
        return restaurantList;
    }

}
