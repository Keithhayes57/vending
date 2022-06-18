package com.techelevator.view;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Locale;
import java.util.Scanner;

public class FeedMoney {


    double totalMoney = 0;
    boolean YOrN = true;
    NumberFormat formatter = new DecimalFormat("#0.00");


    public double FeedMoney() { // the money feeder
        Scanner feedScan = new Scanner(System.in);
        double moneyConversion = 0 ;
        if (YOrN) {
            System.out.println("Enter the amount of money you fed the machine? ($1, $2, $5, $10 :");

            String money = feedScan.nextLine(); // takes money from user as string

            try { // tries to convert the string into double
                moneyConversion = Double.parseDouble(money); //  converts into double
                if (moneyConversion != 10.0 && moneyConversion != 2.0 && moneyConversion != 5.0 && moneyConversion != 1.0) // if they do not enter in the right amount taken by machine
                {
                    System.out.println(" Please enter a valid dollar amount");
                    FeedMoney(); // recalls so user can try again
                }
            } catch (NumberFormatException e) { //  if user enters characters or anything else
                System.out.println("Please enter a valid number");
                System.out.println("Would you like to try again? : ");
                String answer = feedScan.nextLine().toLowerCase(Locale.ROOT); //  prompts user to try to enter money again
                if (answer.contentEquals("y")) {
                    FeedMoney();
                } else {
                    YOrN = false;
                }
            }
            if (  moneyConversion == 1.0 || moneyConversion == 5.0 || moneyConversion == 10.0 || moneyConversion == 2.0) { //  if the user does enter desired amount
                totalMoney += moneyConversion; // updates the balance
                System.out.println("The current balance is: $" + formatter.format(totalMoney)); // tells user the balance
                System.out.println("Do you want to add more ? (Y/N)"); //  asks user if they want to enter in more
                String answer = feedScan.nextLine().toLowerCase(Locale.ROOT);
                if (answer.contentEquals("y")) {
                    YOrN = true;
                    FeedMoney();
                } else {
                    YOrN = false;
                }
            }
        }
        return totalMoney; //  returns the balance to use in machine
    }

    public void setTotalMoney(double totalMoney) {
        this.totalMoney = totalMoney;
    }

    public void setYOrN(boolean YOrN) {
        this.YOrN = YOrN;
    }
}
