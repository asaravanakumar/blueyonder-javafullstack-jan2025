package com.examples.java.collection;

import java.util.*;

/**
 * Basic collection examples
 */
public class CollectionGenericEx {

	public static void main(String[] args) {

		// Ordered list of items. Synchronized. Underlying data structure is Array.
		// Slower compare to ArrayList.
		List<String> countriesVec = new Vector<>();
		countriesVec.add("India");
		countriesVec.add("China");
		countriesVec.add("USA");
		countriesVec.add("Brazil");
		countriesVec.add("India");

		List accountsVec = new Vector();
		accountsVec.add(new Account(100, "Manju", "Savings", 10000.0, "New Delhi"));
		accountsVec.add(new Account(101, "Sanjay", "Current", 50000.0, "Mumbai"));
		accountsVec.add(new Account(102, "Ajay", "Deposit", 75000.0, "Bengaluru"));

		// Prints Vector entries
		System.out.println("\nVector Output..");
		for(Object account: accountsVec) {
			Account account1 = (Account) account;
			System.out.println(account1.getAccountId() + " " + account1.getName());
		}
//		displayAll(countriesVec);
//		displayAll(accountsVec);

//		// Ordered list of items. Underlying data structure is Array.
//		// Faster for random access. Better for frequent reads.
//		List<String> countriesList = new ArrayList<>();
//		countriesList.add("India");
//		countriesList.add("China");
//		countriesList.add("USA");
//		countriesList.add("Brazil");
//		countriesList.add("India");
//
//		// Prints ArrayList entries
//		System.out.println("\nArrayList Output..");
//		displayAll(countriesList);
//
//		// Ordered list of items. Underlying data structure is Doubly LinkedList.
//		// Better for frequent insertions and deletions.
//		LinkedList<String> countriesLinkedList = new LinkedList<>();
//		countriesLinkedList.add("India");
//		countriesLinkedList.add("China");
//		countriesLinkedList.add("USA");
//		countriesLinkedList.add("UK");
//		countriesLinkedList.add("India");
//
//		System.out.println("\nLinkedList Output..");
//		displayListEntries(countriesLinkedList);
//
//		// Prints LinkedList entries using ListIterator
//		//displayListEntries(countriesLinkedList);
//
//		// Unordered set of items. Hashing the element location for faster access.
//		// Better for frequent read and write with no ordering/sorting requirement.
//		Set<String> countriesHashSet = new HashSet<>();
//		countriesHashSet.add("India");
//		countriesHashSet.add("China");
//		countriesHashSet.add("USA");
//		countriesHashSet.add("Brazil");
//		countriesHashSet.add("India");
//
//		// Prints HashSet entries
//		System.out.println("\nHashSet Output..");
//		displayAll(countriesHashSet);
//
//
//		// Sorted set of items. Better for read with sorting requirement.
//		SortedSet<String> countriesTreeSet = new TreeSet<>(); // Natural Sorting
//		countriesTreeSet.add("India");
//		countriesTreeSet.add("China");
//		countriesTreeSet.add("USA");
//		countriesTreeSet.add("Brazil");
//		countriesTreeSet.add("India");
//		// Prints TreeSet entries
//		System.out.println("\nTreeSet Output..");
//		displayAll(countriesTreeSet);
//
//
//		// Ordered set of items. Better for read with ordering requirement.
//		LinkedHashSet<String> countriesLinkedHashSet = new LinkedHashSet<>();
//		countriesLinkedHashSet.add("India");
//		countriesLinkedHashSet.add("China");
//		countriesLinkedHashSet.add("USA");
//		countriesLinkedHashSet.add("Brazil");
//		countriesLinkedHashSet.add("India");
//		// Prints LinkedHashSet entries
//		System.out.println("\nLinkedHashSet Output..");
//		displayAll(countriesLinkedHashSet);
//
//
//		// Unordered map of items by keys. Hashing the entry key location for faster
//		// access. Better for frequent read and write with no ordering/sorting.
//		Map<String, String> countriesHashMap = new HashMap<>();
//		countriesHashMap.put("IND", "India");
//		countriesHashMap.put("CHN", "China");
//		countriesHashMap.put("BRZ", "Brazil");
//		countriesHashMap.put("USA", "USA");
//		countriesHashMap.put("IND", "India");
//		countriesHashMap.put("", "India");
//		countriesHashMap.put(null, "India");
//		countriesHashMap.put(null, "UK");
//		// Prints HashMap entries
//		System.out.println("\nHashMap Output..");
//		displayMapEntries(countriesHashMap.entrySet()); // Map.Entry<String, String>
//		displayAll(countriesHashMap.keySet());
//		displayAll(countriesHashMap.values());
//
//		// Same as HashMap with Synchronization
//		Map<String, String> countriesHashTable = new Hashtable<>();
//		countriesHashTable.put("IND", "India");
//		countriesHashTable.put("CHN", "China");
//		countriesHashTable.put("BRZ", "Brazil");
//		countriesHashTable.put("USA", "USA");
//		countriesHashTable.put("IND", "India");
//		// Prints HashMap entries
//		System.out.println("\nHashTable Output..");
//		displayMapEntries(countriesHashTable.entrySet());
//		displayAll(countriesHashTable.keySet());
//		displayAll(countriesHashTable.values());
//
//
//		// Sorted map of items by keys. Better for read with sorting requirement.
//		SortedMap<String, String> countriesTreeMap = new TreeMap<>();
//		countriesTreeMap.put("IND", "India");
//		countriesTreeMap.put("CHN", "China");
//		countriesTreeMap.put("BRZ", "Brazil");
//		countriesTreeMap.put("USA", "USA");
//		countriesTreeMap.put("IND", "India");
//		// Prints TreeMap entries
//		System.out.println("\nTreeMap Output..");
//		displayMapEntries(countriesTreeMap.entrySet());
//		displayAll(countriesTreeMap.keySet());
//		displayAll(countriesTreeMap.values());
//
//
//		// Ordered map of items by keys. Better for read with ordering requirement.
//		LinkedHashMap<String, String> countriesLnkHashMap = new LinkedHashMap<>();
//		countriesLnkHashMap.put("IND", "India");
//		countriesLnkHashMap.put("CHN", "China");
//		countriesLnkHashMap.put("BRZ", "Brazil");
//		countriesLnkHashMap.put("USA", "USA");
//		countriesLnkHashMap.put("IND", "India");
//		// Prints LinkedHashMap entries
//		System.out.println("\nLinkedHashMap Output..");
//		displayMapEntries(countriesLnkHashMap.entrySet());
//		displayAll(countriesLnkHashMap.keySet());
//		displayAll(countriesLnkHashMap.values());
		
	}
		

	static void displayAll(Collection<String> col)
	{
		for(String element: col) {
			System.out.println(element);
		}
		System.out.println();
	}

	
/*
	// Iterates the collection elements
	static void displayAll(Collection col) {
		Iterator itr = col.iterator();
		while (itr.hasNext()) {
			Object item = itr.next();
			if(item instanceof String)
			{
				System.out.print(item + " ");
			}
			if(item instanceof Number)
			{
				System.out.println(Math.sqrt(Double.valueOf(item.toString())) + " ");
			}
			//String str = (String) itr.next();
			
		}

		System.out.println();
	}
*/
	
	// Iterates the list elements with list iterator
	static void displayListEntries(List<String> list) {
		ListIterator<String> itr = list.listIterator();

		while (itr.hasNext()) {
			System.out.print(itr.next() + " ");
		}

		System.out.println();
	}

	// Iterates the map elements
	static void displayMapEntries(Set<Map.Entry<String, String>> set) {
		Iterator<Map.Entry<String, String>> itr = set.iterator();
		System.out.println();
		while (itr.hasNext()) {
			Map.Entry<String, String> entry = itr.next();
			System.out.println(entry.getKey() + " " + entry.getValue() + " ");
		}

		System.out.println();
	}

}
