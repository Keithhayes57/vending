package com.techelevator.view;
import org.junit.Assert;
import org.junit.Test;

import java.io.File;

public class PurchaseMenu2Test {

    @Test
    public void shouldReturnSoldOut() {
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
        String expected =  "Sold Out";

        Assert.assertEquals(expected, message);
    }

    @Test
    public void shouldReturnNotAValidSelection() {
        String message = "";
        FeedMoney feedMoney = new FeedMoney();
        feedMoney.setTotalMoney(10);
        PurchaseMenu2 test = new PurchaseMenu2();

        message =  test.doPurchase("A6", 10);
        String expected =  "Not A Valid Selection, Try Again!";

        Assert.assertEquals(expected, message);
    }

    @Test
    public void shouldReturnPurchasedItem() {
        String message = "";
        FeedMoney feedMoney = new FeedMoney();
        feedMoney.setTotalMoney(10);
        PurchaseMenu2 test = new PurchaseMenu2();

        message =  test.doPurchase("A1", 10);
        String expected = "Here's your Potato Crisps\n" +
                "Crunch Crunch, Yum!\n" +
                "Balance Remaining $6.95\n";

        Assert.assertEquals(expected, message);
    }
}
