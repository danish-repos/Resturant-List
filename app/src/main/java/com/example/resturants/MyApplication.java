package com.example.resturants;

import android.app.Application;
import java.util.Random;
import java.util.ArrayList;

public class MyApplication extends Application {

    public static ArrayList<Restaurant> restaurants;

    @Override
    public void onCreate() {
        super.onCreate();

        // ratings will be random just for the sake of the assignment
        // as we can't ask user for the ratings (for what i can understand)

        restaurants = new ArrayList<>();
        restaurants.add(new Restaurant("KFC","Johar town","0320-1234567","A fast food place", (new Random().nextInt(5) + 1)));
        restaurants.add(new Restaurant("Crust","Model town","0320-7654321","A slow food place",(new Random().nextInt(5) + 1)));

    }
}
