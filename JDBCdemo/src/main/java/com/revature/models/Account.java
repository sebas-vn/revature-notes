package com.revature.models;

import java.io.Serializable;
import java.util.Objects;

public class Account implements Serializable {
	
	private int id;
	private double balance;
	private int ownerId;
	
	public Account() {
		super();
	}

	public Account(int id, double balance) {
		super();
		this.id = id;
		this.balance = balance;
	}

	public Account(int id, double balance, int ownerId) {
		super();
		this.id = id;
		this.balance = balance;
		this.ownerId = ownerId;
	}

	public Account(double balance, int ownerId) {
		super();
		this.balance = balance;
		this.ownerId = ownerId;
	}

	public int getId() {
		return id;
	}

	public int getOwnerId() {
		return ownerId;
	}

	public void setOwnerId(int ownerId) {
		this.ownerId = ownerId;
	}

	public void setId(int id) {
		this.id = id;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	@Override
	public int hashCode() {
		return Objects.hash(balance, id, ownerId);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Account other = (Account) obj;
		return Double.doubleToLongBits(balance) == Double.doubleToLongBits(other.balance) && id == other.id
				&& ownerId == other.ownerId;
	}

	@Override
	public String toString() {
		return "Account [id=" + id + ", balance=" + balance + ", ownerId=" + ownerId + "]";
	}

}
