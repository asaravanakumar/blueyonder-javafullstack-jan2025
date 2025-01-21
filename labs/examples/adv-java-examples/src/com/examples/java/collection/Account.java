package com.examples.java.collection;

public class Account { //implements Comparable<Account> {

	int accountId;
	String name;
	String type;
	double balance;
	String branch;

	public Account() {
		
	}

	public Account(int accountId, String name, String type, double balance, String branch) {
		super();
		this.accountId = accountId;
		this.name = name;
		this.type = type;
		this.balance = balance;
		this.branch = branch;
	}

	public int getAccountId() {
		return accountId;
	}

	public void setAccountId(int accountId) {
		this.accountId = accountId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	public String getBranch() {
		return branch;
	}

	public void setBranch(String branch) {
		this.branch = branch;
	}

	@Override
	public String toString() {
		return "Account [accountId=" + accountId + ", name=" + name + ", type=" + type + ", balance=" + balance
				+ ", branch=" + branch + "]";
	}

//	@Override
//	public int compareTo(Account o) {
//		return this.getAccountId() - o.getAccountId();
//	}

}
