package com.revature.repositories;

import java.util.List;

import com.revature.models.Account;

public interface IAccountDao {
	
	List<Account> findAll(); // returns list of account objects
	int insert(Account a); // return the primary key of the account inserted
	Account findById(int id);
	List<Account> findByOwner(int userId);
	boolean update(Account a);
	boolean delete(int id);
	

}
