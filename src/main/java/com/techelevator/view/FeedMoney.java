package com.techelevator.view;

import java.util.Locale;
import java.util.Scanner;

public class FeedMoney {
    double totalMoney = 0;
    boolean YOrN = true;
    public double FeedMoney(){

        if(YOrN == true) {
            System.out.println("Enter the amount of money you fed the machine? ($1, $2, $5, $10 :");
            Scanner feedScan = new Scanner(System.in);
            String money = feedScan.nextLine();
            double moneyConversion = Double.parseDouble(money);
            totalMoney += moneyConversion;
            System.out.println("The current balance is: " + totalMoney);
            System.out.println("Do you want to add more ? (Y/N)");
            String answer = feedScan.nextLine().toLowerCase(Locale.ROOT);

            if (answer.contentEquals("y")) {
                YOrN = true;
                FeedMoney();
            } else {
                YOrN = false;
            }
        }
        return totalMoney;

    }

    public boolean isYOrN() {
        return YOrN;
    }
}
