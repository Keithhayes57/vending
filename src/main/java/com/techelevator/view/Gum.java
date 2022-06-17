package com.techelevator.view;

public class Gum extends Snack{
    @Override
    public String sounds() {
        return "Chew Chew, Yum!";
    }

    public Gum(String location, String name , double price, int quantity) {
        super(location,name, price, quantity);
    }
}
