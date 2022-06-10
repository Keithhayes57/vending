package com.techelevator.view;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class Inventory {
    public void setSnackList(List<Snack> snackList) {
        this.snackList = snackList;
    }
    public Inventory(){
        this.stockList();
    }
    private  List<Snack> snackList = new ArrayList<>();
    File inventoryFile;
    //Scanner scan = new Scanner("vendingmachine.csv");
 public void stockList()  {
     try (Scanner scan = new Scanner("vendingmachine.csv")){
         while (scan.hasNextLine()){
             String line = scan.nextLine();
             String [] split = line.split("|");
             if (split[3].equalsIgnoreCase("Chip"))
             {
                 Chip c = new Chip(split[0],split[1],Double.parseDouble(split[2]));
                 snackList.add(c);
             }
             if (split[3].equals("Candy"))
             {
                 Candy c = new Candy(split[0],split[1],Double.parseDouble(split[2]));
                 snackList.add(c);
             }
             if (split[3].equals("Gum"))
             {
                 Gum g = new Gum(split[0],split[1],Double.parseDouble(split[2]));
                 snackList.add(g);
             }
             if (split[3].equals("Drink"))
             {
                 Drinks d = new Drinks(split[0],split[1],Double.parseDouble(split[2]));
                 snackList.add(d);
             }

                                //System.out.println(line);
         }

     }
     catch(Exception e){
         System.err.println("Does not exist");
     }
 }
 public void displayList(){
     for ( Snack snack : snackList){
         System.out.println(snack.getLocation());
         System.out.println(snack.getName());
         System.out.println(snack.getPrice());
         System.out.println(snack.getQuanitity());
     }
 }

}
