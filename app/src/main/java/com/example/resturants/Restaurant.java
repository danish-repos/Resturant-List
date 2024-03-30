package com.example.resturants;

public class Restaurant {
    private String name;
    private String location;
    private String phoneNumber;
    private String description;
    private String rating;

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

    public String getRating(){return  rating;}

    public void setRating(String rating){this.rating = rating;}

    public void setDescription(String description) {
        this.description = description;
    }

    public Restaurant(String name, String location, String phoneNumber, String description, String rating) {
        this.name = name;
        this.location = location;
        this.phoneNumber = phoneNumber;
        this.description = description;
        this.rating = rating;
    }

    @Override
    public String toString() {
        return "Restaurant{" +
                "name='" + name + '\'' +
                ", location='" + location + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
