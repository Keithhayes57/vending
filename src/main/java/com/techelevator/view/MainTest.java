package com.techelevator.view;

import java.io.File;

public class MainTest {
    public static void main(String[] args) {
        String message = "";
        FeedMoney feedMoney = new FeedMoney();
        feedMoney.setTotalMoney(10);
        PurchaseMenu2 test = new PurchaseMenu2();
        test.doPurchase("A1", 10);
        test.doPurchase("A1", 10);
        test.doPurchase("A1", 10);
        test.doPurchase("A1", 10);
        test.doPurchase("A1", 10);
        message =  test.doPurchase("A1", 10);
        System.out.println(message);
    }
}
