package com.example.myapplication;

public class data{
    private static int id;
    private String restaurant;

    public data(String restaurant){
        this.restaurant=restaurant;
    }

    public static int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    public String getRestaurant() {
        return restaurant;
    }

    public void setRestaurant(String restaurant) {
        this.restaurant = restaurant;
    }

}