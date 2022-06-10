package com.techelevator.view;

public class Drinks extends Snack{
    @Override
    public String sounds() {
        return "Glug Glug, Yum!";
    }

    public Drinks(String name, String location, double price) {
        super(name, location, price);
    }
}
