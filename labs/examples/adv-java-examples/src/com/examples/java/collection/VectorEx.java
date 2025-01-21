package com.examples.java.collection;

import java.util.Iterator;
import java.util.ListIterator;
import java.util.Vector;

/*
* Ordered list of items. Synchronized. Underlying data structure is Array.
* Slower compare to ArrayList.
*/
public class VectorEx {

	public void test() {
		System.out.println("Testing...");
	}
	public static void main(String[] args) {

//		String[] skills = new String[100];
//		skills[0] = "Java";
//		skills[1] = "Python";

		String name = "Hello";

		Vector<String> skills = new Vector<>();

		skills.add("Java");
		skills.add("Python");
		skills.add(".Net");
		skills.add("PHP");
//		skills.add(100);
//		skills.add(200.0);
//		skills.add(false);
//		skills.add(new Account());
		
		System.out.println(skills);
		
		System.out.println(skills.get(1));
//		skills.set(2, "Node JS");

		skills.add("Node JS");

		System.out.println(skills);

		skills.remove(2);
		skills.remove("PHP");

		System.out.println(skills);

		System.out.println(skills.indexOf("Python"));
		System.out.println(skills.contains("PHP"));

		System.out.println(skills.subList(0, 2));

//		for(String skill: skills) {
//			System.out.println(skill);
//		}

//		Object[] skillsArr = skills.toArray();
//
//		System.out.println(skillsArr);
//
//		for(Object skill: skillsArr) {
//			System.out.println(skill);
//		}

		String[] countriesArr = {"India", "UK", "USA", "Japan" };
//
		//List countries = List.of(countriesArr);
//
//		List countries = Arrays.asList(countriesArr);
//
//		List countriesV = new Vector();
//		countriesV.addAll(countries);
//
//		System.out.println(countries);
//		System.out.println(countriesV);
//
//		if(countries instanceof ArrayList) {
//			System.out.println("ArrayList created");
//		} else if(countries instanceof Vector) {
//			System.out.println("Vector created");
//		} else {
//			System.out.println("List created");
//		}
//
		Iterator it = skills.iterator();

		while(it.hasNext()) {
			System.out.println(it.next());
		}

		ListIterator lit = skills.listIterator(skills.size());

//		while(lit.hasNext()) {
//			System.out.println("Has next element");
//			System.out.println(lit.nextIndex() + " " + lit.next());
////			System.out.println(lit.nextIndex() + " " + lit.next());
////			System.out.println(lit.nextIndex() + " " + lit.next());
////			lit.remove();
////			lit.add("Javascript");
//		}


		while(lit.hasPrevious()) {
			System.out.println("Has previous element");
			System.out.println(lit.previousIndex() + " " + lit.previous());
//			System.out.println(lit.previousIndex() + " " + lit.previous());
//			System.out.println(lit.previousIndex() + " " + lit.previous());
		}
		
	}

}
