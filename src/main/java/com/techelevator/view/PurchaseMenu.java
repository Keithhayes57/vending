package com.techelevator.view;
import java.io.File;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.Scanner;


public class PurchaseMenu extends Menu {
    private static final String Purchase_MAIN_MENU_OPTION_FEED_MONEY = "Feed Money";
    private static final String PURCHASE_MAIN_MENU_OPTION_SELECT_PRODUCT = "Select Product";
    private static final String PURCHASE_MAIN_MENU_OPTIONS_FINISH_TRANSACTION = "Finish Transaction";
    public static final String[] PURCHASE_MAIN_MENU_OPTIONS = { Purchase_MAIN_MENU_OPTION_FEED_MONEY, PURCHASE_MAIN_MENU_OPTION_SELECT_PRODUCT, PURCHASE_MAIN_MENU_OPTIONS_FINISH_TRANSACTION };
    private double balance = 0;
    private Scanner input = new Scanner(System.in);
    private Inventory inventory = new Inventory(new File("capstone-1/vendingmachine.csv"));

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public PurchaseMenu(InputStream input, OutputStream output) {
        super(input, output);
    }                                                                               // after change in access modifier in Menu, override the methods if needed

    @Override
    public Object getChoiceFromOptions(Object[] options) {
        return super.getChoiceFromOptions(options);
    }

    @Override
    public Object getChoiceFromUserInput(Object[] options) {
        return super.getChoiceFromUserInput(options);
    }

    @Override
    public void displayMenuOptions(Object[] options) {
        super.displayMenuOptions(PURCHASE_MAIN_MENU_OPTIONS);
    }

    public int PurchaseMenu(){

            System.out.println("1) Feed Money");
            System.out.println("2) Select Product");
            System.out.println("3) Finish Transaction");
            System.out.println();
            System.out.println("Current Money : " + balance);
        System.out.println();
        System.out.println("Please select 1,2,or 3:");
        Scanner input = new Scanner(System.in);
        String selection = input.nextLine();
        return Integer.parseInt(selection);
    }

    public void secondOption(){
        inventory.displayInventory();
        System.out.println();
        System.out.println("Enter a location: ");
        System.out.println("Balance: $" + balance);
        String location = input.nextLine();
        for (Snack menu : inventory.getInventory()){
            if(location.contentEquals(menu.getLocation())){
                location = menu.getLocation();
                if(menu.getQuantity() == 0){
                    System.out.println("Sold Out");
                }else if (balance >= menu.getPrice()){
                    balance -= menu.getPrice();
                    System.out.println("Here's your " + menu.getName());
                    System.out.println(menu.sounds());
                    System.out.println();
                    System.out.println("Balance Remaining $" + balance);
                    System.out.println();
                    menu.setQuantity(menu.getQuantity()-1);
                }else if(balance <= 0){
                    System.out.println("You don't have enough money for " + menu.getName());
                }else{
                    System.out.println("Cannot find that location");
                }
            }
        }
    }



}
