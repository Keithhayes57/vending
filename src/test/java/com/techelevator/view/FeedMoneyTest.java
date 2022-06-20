package com.techelevator.view;

import org.junit.Test;
import com.techelevator.VendingMachineCLI;
import org.junit.Assert;
import org.junit.Test;

import java.io.File;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.Scanner;
public class FeedMoneyTest {
    @Test
    public void correctBalance(){
        FeedMoney feedMoney = new FeedMoney();
        feedMoney.setTotalMoney(10);
        PurchaseMenu2 test = new PurchaseMenu2();
        Assert.assertEquals(10.0,feedMoney.totalMoney,0.0001);

    }


}
