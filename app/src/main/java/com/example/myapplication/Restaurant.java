package com.example.myapplication;

public class Restaurant {
    private int id;

    public Restaurant(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public Restaurant(String name) {
        this.name = name;
    }

    private String name;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
