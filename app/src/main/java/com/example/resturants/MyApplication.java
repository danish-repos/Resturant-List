package com.example.resturants;

import android.app.Application;

import java.util.ArrayList;

public class MyApplication extends Application {

    public static ArrayList<Restaurant> restaurants;

    @Override
    public void onCreate() {
        super.onCreate();

        restaurants = new ArrayList<>();
        restaurants.add(new Restaurant("KFC","Johar town","0320-1234567","A fast food place"));
        restaurants.add(new Restaurant("Crust","Model town","0320-7654321","A slow food place"));

    }
}
