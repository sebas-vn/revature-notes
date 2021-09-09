package com.revature.services;

import java.util.List;
import java.util.Scanner;

import com.revature.models.Account;
import com.revature.models.User;
import com.revature.repositories.AccountDao;
import com.revature.repositories.IAccountDao;

public class AccountService {
	// Inject the dependency that Account Service needs to persist data
	public IAccountDao adao = new AccountDao();
	
	// create an open account method that will include a scanner and call the accDao.insert()
	
	Scanner scan = new Scanner(System.in);
	
	public Account openAccount(User u) {
		
		/*
		 * When thos method os called 
		 * it prompts the user to enter an initial deposit
		 * 
		 * it reads back to the user the deposit entered
		 * 
		 * it creates a new account with user's id as the accounts owner if property
		 * 
		 * then it called the adao.insert method to persis the account to the dbs
		 */
		
		
		System.out.println("Enter the amount to deposit");
		double depositAmount = scan.nextDouble();
		
		System.out.println("Creating account...");
		
		Account a = new Account(depositAmount, u.getId());
		
		a.setId(adao.insert(a));
		
		return a;
	}
	
	public void viewAllAccountsByOwner(int ownerId) {
		for (Account a : adao.findByOwner(ownerId)) {
			System.out.println(a);
		}
	}
	
	public List<Account> findByOwner(int userId) {
		return adao.findByOwner(userId);
	}
} 
