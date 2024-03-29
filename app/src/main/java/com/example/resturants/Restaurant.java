package com.example.resturants;

public class Restaurant {
    private String name;
    private String location;
    private String phoneNumber;
    private String description;

    private int rating;

    public Restaurant() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getDescription() {
        return description;
    }

    public int getRating(){return  rating;}

    public void setRating(int rating){this.rating = rating;}

    public void setDescription(String description) {
        this.description = description;
    }

    public Restaurant(String name, String location, String phoneNumber, String description, int rating) {
        this.name = name;
        this.location = location;
        this.phoneNumber = phoneNumber;
        this.description = description;
        this.rating = rating;
    }

    @Override
    public String toString() {
        return "Resturant{" +
                "name='" + name + '\'' +
                ", location='" + location + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
