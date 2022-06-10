package com.techelevator.view;

public abstract class Snack {
    public abstract String sounds();
    private String name;
    private String location;
    private double price;



    private int quanitity = 5;

    public Snack(String name, String location, double price) {
        this.name = name;
        this.location = location;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public String getLocation() {
        return location;
    }

    public double getPrice() {
        return price;
    }
    public int getQuanitity() {
        return quanitity;
    }
}
