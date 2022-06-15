package com.techelevator;

import com.techelevator.view.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Scanner;

public class VendingMachineCLI {

	private static final String MAIN_MENU_OPTION_DISPLAY_ITEMS = "Display Vending Machine Items";
	private static final String MAIN_MENU_OPTION_PURCHASE = "Purchase";
	private static final String MAIN_MENU_OPTIONS_EXIT = "Exit";
	private static final String[] MAIN_MENU_OPTIONS = {MAIN_MENU_OPTION_DISPLAY_ITEMS, MAIN_MENU_OPTION_PURCHASE, MAIN_MENU_OPTIONS_EXIT};
	private double balance = 0; // future reference for FEED Money staring balance
	private final Menu menu;
	private final Inventory inventory = new Inventory(new File("vendingmachine.csv"));

	FeedMoney feedMoney = new FeedMoney();

	private PurchaseMenu purchaseMenu = new PurchaseMenu(InputStream.nullInputStream(), OutputStream.nullOutputStream());

	public VendingMachineCLI(Menu menu) {                    // ,purchaseMenu purchaseMenu?
		this.menu = menu;

	}

	public void run() throws FileNotFoundException {
		while (true) {
			String choice = (String) menu.getChoiceFromOptions(MAIN_MENU_OPTIONS);
			if (choice.equals(MAIN_MENU_OPTION_DISPLAY_ITEMS)) {

				inventory.displayInventory();//System.out.println(inventory.stockList());// display vending machine items
			} else if (choice.equals(MAIN_MENU_OPTION_PURCHASE)) {
				do {
					int choice2 = purchaseMenu.PurchaseMenu();

					switch (choice2) {
						case 1:
							double money = feedMoney.FeedMoney();
							purchaseMenu.setBalance(money);
							balance = purchaseMenu.getBalance();
							break;
						case 2:
							purchaseMenu.secondOption();
						case 3:
							break;

						default:
							System.out.println("Invalid menu choice; try again.");
							break;
					}
				} while (true);

			}else if(choice.equals(MAIN_MENU_OPTIONS_EXIT)){
				break;
			}
		}
	}

	public static void main(String[] args) throws FileNotFoundException {
		Menu menu = new Menu(System.in, System.out); // probably need PurchaseMenu purchase Menu = new PurchaseMenu(in,out)
		VendingMachineCLI cli = new VendingMachineCLI(menu); // also ^^
		cli.run();
	}
}
