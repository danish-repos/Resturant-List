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
        restaurants.add(new Restaurant("KFC","Johar town","1","A fast food place", Math.round(new Random().nextDouble() * 500) / 100.0));
        restaurants.add(new Restaurant("Crust","Model town","2","A slow food place",Math.round(new Random().nextDouble() * 500) / 100.0));
        restaurants.add(new Restaurant("Johnny and Jugnu","Model town","3","Informal take-outs and wraps",Math.round(new Random().nextDouble() * 500) / 100.0));
        restaurants.add(new Restaurant("Subway","Model town","4","Dive-in, takeaway ",Math.round(new Random().nextDouble() * 500) / 100.0));
        restaurants.add(new Restaurant("Daily Deli Co.","Model town","5","Dive-In takeaway",Math.round(new Random().nextDouble() * 500) / 100.0));

    }
}
