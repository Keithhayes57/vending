package com.techelevator.view;
import java.io.File;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Scanner;

public class PurchaseMenu2 {

    private static final String Purchase_MAIN_MENU_OPTION_FEED_MONEY = "Feed Money";
    private static final String PURCHASE_MAIN_MENU_OPTION_SELECT_PRODUCT = "Select Product";
    private static final String PURCHASE_MAIN_MENU_OPTIONS_FINISH_TRANSACTION = "Finish Transaction";
    public static final String[] PURCHASE_MAIN_MENU_OPTIONS = {Purchase_MAIN_MENU_OPTION_FEED_MONEY, PURCHASE_MAIN_MENU_OPTION_SELECT_PRODUCT, PURCHASE_MAIN_MENU_OPTIONS_FINISH_TRANSACTION};
    private FeedMoney feed = new FeedMoney();
    private double balance = feed.totalMoney;
    NumberFormat formatter = new DecimalFormat("#0.00");
    private Scanner input = new Scanner(System.in);
    private Inventory inventory = new Inventory(new File("/Users/jessegoodrum/Desktop/Merit America/Captstone Try 3/capstone-1/vendingmachine.csv"));
    private Logger log = new Logger();

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public int PurchaseMenu2() { //  prompts user to choose option and returns their option as int

        System.out.println("1) Feed Money");
        System.out.println("2) Select Product");
        System.out.println("3) Finish Transaction");
        System.out.println();
        int intSelection = 0;
        System.out.println("Please select 1, 2, or 3:");
        Scanner input = new Scanner(System.in);
        String selection = input.nextLine();
        try {
            intSelection = Integer.parseInt(selection);
        } catch (NumberFormatException e) {
            System.out.println("Please enter 1, 2, or 3 ");
        }

        return intSelection;
    }

    public String doPurchase(String location, double balance) { //does the purchasing of item, takes the location and balance as input
        for (Snack menu : inventory.getInventory()) { // iterates through the inventory
            if (location.contentEquals(menu.getLocation())) { //  if location is found in inventory
                location = menu.getLocation();
                if (menu.getQuantity() == 0) { //  if the quantity is zero
                    return "Sold Out";
                } else if (balance >= menu.getPrice()) { //  if they have the money, and the stock is there, the purchase is made
                    balance -= menu.getPrice(); // updates the balance
                    log.log(menu.getName() + " " + menu.getLocation() + " $" + menu.getPrice() + " $" + formatter.format(balance));// logs the transaction
                    menu.setQuantity(menu.getQuantity() - 1);// updates quantity within loop
                    return "Here's your " + menu.getName() + "\n" + menu.sounds() + "\n" + "Balance Remaining $" + formatter.format(balance) + "\n"; // returns message
                } else if (balance <= menu.getPrice()) { // if user does not have the funds
                    return "You don't have enough money for " + menu.getName();
                }
            }
        }
        return "Not A Valid Selection, Try Again!"; // happens if user enters in wrong location
    }
}
