package com.techelevator;

import com.techelevator.view.*;

import java.io.File;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Locale;
import java.util.Scanner;

public class VendingMachineCLI {

	private static final String MAIN_MENU_OPTION_DISPLAY_ITEMS = "Display Vending Machine Items";
	private static final String MAIN_MENU_OPTION_PURCHASE = "Purchase";
	private static final String MAIN_MENU_OPTIONS_EXIT = "Exit";
	private static final String[] MAIN_MENU_OPTIONS = {MAIN_MENU_OPTION_DISPLAY_ITEMS, MAIN_MENU_OPTION_PURCHASE, MAIN_MENU_OPTIONS_EXIT};
	private double balance = 0;
	NumberFormat formatter = new DecimalFormat("#0.00"); // formats balance to two decimal places
	private Menu menu;
	private Inventory inventory = new Inventory(new File("capstone-1/vendingmachine.csv"));
	private Logger log = new Logger();
	private FeedMoney feedMoney = new FeedMoney();
	private PurchaseMenu2 purchaseMenu2 = new PurchaseMenu2();
	private Scanner input = new Scanner(System.in);




	public VendingMachineCLI(Menu menu) {
		this.menu = menu;

	}

	public void run() { //runs choices and menu
		while (true) {
			String choice = (String) menu.getChoiceFromOptions(MAIN_MENU_OPTIONS);
			if (choice.equals(MAIN_MENU_OPTION_DISPLAY_ITEMS)) { // when user wants to just display the inventory
				inventory.displayInventory();
			} else if (choice.equals(MAIN_MENU_OPTION_PURCHASE)) {// if they choose 2
				do { // do while to run loop while user has chosen purchase menu
					System.out.println();
					System.out.println("Current Balance : $" + formatter.format(balance));// shows initial balance
					System.out.println();
					int choice2 = purchaseMenu2.purchaseMenu2(); //  gets purchase menu choice from user

					switch (choice2) {
						case 1: //  if user chooses 1
							double money = feedMoney.FeedMoney(); // allows user to feed money into machine
							feedMoney.setYOrN(true); //  resets to allow user to add more money
							purchaseMenu2.setBalance(money); // sets balance to the fed money for the purchaseMenu
							balance = purchaseMenu2.getBalance(); // updates this class balance
							log.log("Feed Money: " + " " + money + " $" + formatter.format(balance) + " "  ); //  logs the money being fed
							break; //  breaks out of case and allows user to choose option again
						case 2: //  when user chooses to purchase items
							inventory.displayInventory(); //  displays the inventory
							System.out.println();
							System.out.println("Balance: $" + formatter.format(balance)); //  reminds user of their balance
							System.out.println();
							System.out.println("Enter a location: ");
							String location = input.nextLine().toUpperCase(Locale.ROOT); //  gets location of item
							String message = purchaseMenu2.doPurchase(location, balance); // runs the purchase and returns a message
							System.out.println(message);// the message returned (either it went through, or didn't
							for (Snack menu : inventory.getInventory()) { //  this loop updates the quantity of the items and sets the balance to reflect a purchase
								if (location.contentEquals(menu.getLocation()) && menu.getPrice() <= balance && menu.getQuantity() >0 ) {
									menu.setQuantity(menu.getQuantity() - 1);
									balance -= menu.getPrice();
									feedMoney.setTotalMoney(balance);
								}
							}
							choice = MAIN_MENU_OPTION_PURCHASE; // changes the choice back to the purchase menu
							break;// breaks out and allows user to use purchase menu again
						case 3: // if user chooses 3
							System.out.println("Your change is $" + formatter.format(balance)); //  gives change
							log.log("Give Change : " + "$"+ formatter.format(balance) + " " + "$0.00"); //  logs the change given
							balance = 0; // resets balance to zero
							feedMoney.setTotalMoney(balance); //  resets wallet to zero
							choice = (String) menu.getChoiceFromOptions(MAIN_MENU_OPTIONS); //  updates the choice to go back to main menu
							break; //  breaks out and goes to main menu

						default: //  only happens when user doesn't choose 1,2,or3
							System.out.println("Invalid menu choice; try again.");
							break;
					}
				} while(choice.equals(MAIN_MENU_OPTION_PURCHASE));{ //  this loop happens while the user has chosesn purchase menu
				break;}
			}
			else if(choice.equals(MAIN_MENU_OPTIONS_EXIT)){ //  if user chooses to exit and does not do anything
				System.out.println("Bye");
				input.close();
				break;
			}
		}
	}

	public static void main(String[] args) {
		Menu menu = new Menu(System.in, System.out);
		VendingMachineCLI cli = new VendingMachineCLI(menu);
		cli.run();

	}
}
