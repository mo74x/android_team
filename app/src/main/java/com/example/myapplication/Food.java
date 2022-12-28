package com.example.myapplication;

public class Food {
    private int id,price;
    private String restaurant,description,name;

    public Food(int price, String restaurant, String description, String name) {
        this.price = price;
        this.restaurant = restaurant;
        this.description = description;
        this.name = name;
    }

    public Food(int id, int price, String restaurant, String description, String name) {
        this.id = id;
        this.price = price;
        this.restaurant = restaurant;
        this.description = description;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getRestaurant() {
        return restaurant;
    }

    public void setRestaurant(String restaurant) {
        this.restaurant = restaurant;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
