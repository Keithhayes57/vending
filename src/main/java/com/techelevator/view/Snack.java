package com.techelevator.view;

import java.util.List;

public abstract class Snack {
    public abstract String sounds();
    private String name;
    private String location;
    private double price;



    private int quantity = 5;

    public Snack(String location, String name, double price) {
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

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
