package com.techelevator.view;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.Scanner;


public class PurchaseMenu extends Menu {
    private static final String Purchase_MAIN_MENU_OPTION_FEED_MONEY = "Feed Money";
    private static final String PURCHASE_MAIN_MENU_OPTION_SELECT_PRODUCT = "Select Product";
    private static final String PURCHASE_MAIN_MENU_OPTIONS_FINISH_TRANSACTION = "Finish Transaction";
    public static final String[] PURCHASE_MAIN_MENU_OPTIONS = { Purchase_MAIN_MENU_OPTION_FEED_MONEY, PURCHASE_MAIN_MENU_OPTION_SELECT_PRODUCT, PURCHASE_MAIN_MENU_OPTIONS_FINISH_TRANSACTION };
 public double balance = 0;

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

    public void PurchaseMenu(){

            System.out.println("1) Feed Money");
            System.out.println("2) Select Product");
            System.out.println("3) Finish Transaction");
            System.out.println();
            System.out.println("Current Money : " + balance);
    }



}
