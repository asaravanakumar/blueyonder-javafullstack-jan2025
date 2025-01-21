package com.examples.java.collection;

import java.util.HashMap;

public class HashMapEx {
	
	private static HashMap<Integer, Account>  accounts;
	
	public static void main(String[] args) {
		
		accounts = new HashMap<>();

		Account account1 = new Account(100, "Anil", "Savings", 50000.0, "Pune");
		Account account2 = new Account(101, "Manish", "Deposit", 100000.0, "Chennai");
		Account account3 = new Account(99, "Kunal", "Deposit", 100000.0, "Chennai");
		accounts.put(100, account1);
		accounts.put(101, account2);
		accounts.put(99, account3);
		accounts.put(null, null);
		accounts.put(null, account1);
//		accounts.put(200,  new String("Account200"));
		
		account3.setBalance(50000);
		accounts.put(99, account3);
		
//		System.out.println(accounts);
		
		Account account = accounts.get(null);
		
		System.out.println(account);
		
		if(account != null) {
			System.out.println(account.getName());
		} else {
			System.out.println("No account found for given id");
		}
		
		System.out.println(accounts.keySet());

//		Set<Integer> accountIds = accounts.keySet();
//		for(int id: accountIds) {
//			Account acc = accounts.get(id);
//			System.out.println(acc.getName());
//		}
		
	}
	
	public static Account getAccount(int accountId) {
		return accounts.get(accountId);
	}
	
	public static void showAccountDetails() {
		
	}

}
