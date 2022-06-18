package com.techelevator.view;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.File;

public class PurchaseMenu2Test {

    @Test
    public void shouldReturnSoldOut() {
        String message = "";
        FeedMoney feedMoney = new FeedMoney();
        feedMoney.setTotalMoney(10);
        Inventory inventory = new Inventory(new File("/capstone-1/vendingmachine.csv"));
        PurchaseMenu2 test = new PurchaseMenu2();
        test.doPurchase("A1", 10);
        test.doPurchase("A1", 10);
        test.doPurchase("A1", 10);
        test.doPurchase("A1", 10);
        test.doPurchase("A1", 10);
       message =  test.doPurchase("A1", 10);
       String expected =  "Sold Out";

        Assert.assertEquals(expected, message);
    }
}
