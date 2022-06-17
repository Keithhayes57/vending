package com.techelevator.view;

public class Chip extends Snack {
    @Override
    public String sounds() {
        return "Crunch Crunch, Yum!";
    }

    public Chip(String location, String name, double price, int quantity) {
        super(location,name, price, quantity);
    }
}
