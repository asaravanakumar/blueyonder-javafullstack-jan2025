package com.examples.java.collection;

import java.util.Comparator;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class TreeMapEx {
	
	public static void main(String[] args) {

		Comparator<Integer> ACCOUNT_COMPARATOR = new Comparator<Integer>() {
			@Override
			public int compare(Integer o1, Integer o2) {
				return o2 - o1;
			}
		};
		
//		Map<Integer, Account>  accounts = new TreeMap<>();
		Map<Integer, Account>  accounts = new TreeMap<>(ACCOUNT_COMPARATOR);

		Account account1 = new Account(100, "Anil", "Savings", 50000.0, "Pune");
		Account account2 = new Account(101, "Manish", "Deposit", 100000.0, "Chennai");
		Account account3 = new Account(99, "Kunal", "Deposit", 100000.0, "Chennai");
		accounts.put(account1.getAccountId(), account1);
		accounts.put(account2.getAccountId(), account2);
		accounts.put(account3.getAccountId(), account3);

		account3.setBalance(50000);
		accounts.remove(99);
		accounts.put(199, account3);
		//accounts.put(99, account3);
		
		System.out.println(accounts);
		
		System.out.println(accounts.keySet());
		
		Set<Integer> accountIds = accounts.keySet();
		for(int id: accountIds) {
			System.out.println(id);
		}
		
//		Collection<Account> values = accounts.values();)
		for(Account account: accounts.values()) {
			System.out.println(account);
		}
		
		//Map.Entry
		Set<Map.Entry<Integer, Account>> entries = accounts.entrySet();
		for(Map.Entry entry: entries) {
			System.out.println(entry.getKey() + " - " + entry.getValue());
		}
				
		
	}

}
