package com.example.resturants;

public class Restaurant {
    private String name;
    private String location;
    private String phoneNumber;
    private String description;

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

    public void setDescription(String description) {
        this.description = description;
    }

    public Restaurant(String name, String location, String phoneNumber, String description) {
        this.name = name;
        this.location = location;
        this.phoneNumber = phoneNumber;
        this.description = description;
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
