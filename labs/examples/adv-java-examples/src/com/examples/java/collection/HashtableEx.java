package com.examples.java.collection;

import java.util.*;

public class HashtableEx {
	
	public static void main(String[] args) {
		
		Map<Integer, Account>  accounts = new Hashtable<>();

		Account account1 = new Account(100, "Anil", "Savings", 50000.0, "Pune");
		Account account2 = new Account(101, "Manish", "Deposit", 100000.0, "Chennai");
		Account account3 = new Account(99, "Kunal", "Deposit", 100000.0, "Chennai");
		Account account4 = new Account(100, "Surya", "Loan", 100000.0, "Gurugram");
		accounts.put(100, account1);
		accounts.put(101, account2);
		accounts.put(99, account3);
		accounts.put(102, account1);
		
		account3.setBalance(50000);
		accounts.put(99, account3);

		accounts.remove(101);
		
		System.out.println(accounts);

		List keys = Arrays.asList(accounts.keySet().toArray());
		Collection values = accounts.values();
		
		System.out.println(keys);

		System.out.println(values);

		Set<Integer> accountIds = accounts.keySet();
		for(int id: accountIds) {
			System.out.println(accounts.get(id));
		}

		// Set of Map.Entry objects with generics
		Set<Map.Entry<Integer, Account>> entries = accounts.entrySet();

		for (Map.Entry entry: entries) {
			System.out.println(entry.getKey() + " " + entry.getValue());
		}

		// Set of Map.Entry objects w/o generics
		Set entries1 = accounts.entrySet();

		for (Object entry: entries1) {
			Map.Entry entry1 = (Map.Entry) entry;
			System.out.println(entry1);
			System.out.println(entry1.getKey());
			System.out.println(entry1.getValue());
		}
		
	}

}
