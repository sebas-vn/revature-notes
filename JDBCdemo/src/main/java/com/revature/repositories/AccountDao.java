package com.revature.repositories;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.revature.models.Account;
import com.revature.util.ConnectionUtil;

public class AccountDao implements IAccountDao{
	
	private static Logger log = Logger.getLogger(AccountDao.class);

	@Override
	public List<Account> findAll() {
		
		// start out with an empty arrayList of accounts 
		List<Account> accountList= new ArrayList<Account>();
		
		// obtain a connections, sorrounf with try
		
		try (Connection conn = ConnectionUtil.getConnection()) {
			
			// create a statement + a sql string to pass through and execute hte DBV
			Statement stmt = conn.createStatement();
			
			String sql = "SELECT * FROM sebasvn.accounts";
			
			// send the statement to the d
			ResultSet rs = stmt.executeQuery(sql);
			
			// iterate through the response while(rs.next())
			while(rs.next()) {
				
				// for each row, grab the data to that account
				int id = rs.getInt("id");
				double balance = rs.getDouble("balance");
				// construct de account object
				Account a = new Account(id, balance);
			
				// 
				accountList.add(a);
			
			}
			
		} catch (SQLException e) {
			log.warn("A SQL Exception occurred when querying all accounts");
			e.printStackTrace();
		}
		
		return accountList;
	}

	@Override
	public int insert(Account a) { // retuirn the primary key of the inserted account
		
		try(Connection conn = ConnectionUtil.getConnection()) {
			
			String sql = "Insert INTO sebasvn.accounts (balance, acc_owner) VALUES (?, ?) RETURNING sebasvn.accounts.id";
			
			PreparedStatement stmt = conn.prepareStatement(sql);
			
			stmt.setDouble(1, a.getBalance());
			stmt.setInt(2, a.getOwnerId());
			
			ResultSet rs;
			
			if ((rs = stmt.executeQuery()) != null) {
				rs.next();
				int id = rs.getInt(1);
				return id;
			}
			
		} catch (SQLException e) {
			log.warn("Unable to insert account");
			e.printStackTrace();
			return -1;
		} 
		
		return -1;
	}

	@Override
	public List<Account> findByOwner(int userId) {
		
		List<Account> ownedAccounts = new ArrayList<Account>();
		
		try (Connection conn = ConnectionUtil.getConnection()) {
			String sql = "SELECT sebasvn.accounts.id, sebasvn.accounts.balance FROM sebasvn.accounts\n"
					+ "INNER JOIN sebasvn.users_accounts_jt \n"
					+ "ON sebasvn.accounts.id = sebasvn.users_accounts_jt.acc_owner \n"
					+ "WHERE sebasvn.users_accounts_jt.acc_owner = ?";
			
			PreparedStatement stmt = conn.prepareStatement(sql);
			
			stmt.setInt(1, userId);
			
			ResultSet rs = stmt.executeQuery();
			
			while (rs.next()) {
				int id = rs.getInt("id");
				double balance = rs.getDouble("balance");
				
				Account a = new Account(id, balance);
				
				// in the case that there are dupolicates, DON'T add them to the arrayList
				if(!(ownedAccounts.contains(a))) {
					ownedAccounts.add(a);
				}
			}
			
			
		} catch (SQLException e) {
			log.warn("Failed to retrieve all accounts owned by user with id " + userId);
			e.printStackTrace();
		}
		
		return ownedAccounts;
	}

	@Override
	public boolean update(Account a) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(int id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Account findById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

}
