package com.revature;

import java.util.ArrayList;
import java.util.Scanner;

import com.revature.models.Account;
import com.revature.models.Role;
import com.revature.models.User;
import com.revature.services.AccountService;
import com.revature.services.UserService;

public class App {
	
	public static void main(String[] args) {
		
		menu();

	}
	
	public static void menu() {
		UserService userv = new UserService();
		AccountService aserv = new AccountService();
		Scanner scan = new Scanner(System.in);
		
		System.out.println("Welcome! if you are a Customer please press 1. \n If you would like to login please press 2.");
		
		int input = scan.nextInt();
		
		if (input == 1) {
			// create a new user
			System.out.println("Enter your username");
			String username = scan.next();
			
			System.out.println("Enter your password");
			String password = scan.next();
			
			User u = new User(username, password, Role.Customer, new ArrayList<Account>()); 
			
			
			u = userv.register(u);
			
			System.out.println("Would you like to open an account?");	
			
			String yesOrNo = scan.next();
			
			if (yesOrNo.contains("y")) {
				
				for (int i=0; i < 2; i++) {
					System.out.println("Opening account #" + i);
					aserv.openAccount(u);
				}
				
				for (Account a : u.getAccounts()) {
					System.out.println(a);
				}
			}
			
		} else {
			System.out.println("Goodbye!");
			System.exit(0);
			
		}
	}
	
}