package com.examples.java.collection;

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LinkedListEx {
	
	public static void main(String[] args) {
		// LinkedList as List
		System.out.println("LinkedList as List...");
		List skills = new LinkedList();
		skills.add("Java");
		skills.add("Python");
		skills.add(".Net");
		skills.add("Java");
		skills.add(null);
		skills.add(null);

		System.out.println(skills);
		skills.add(1,"Node JS");
		skills.set(2, "PHP");
		skills.remove(4);

		System.out.println(skills);

		System.out.println(skills.get(1));

		System.out.println("\nLinkedList as Queue...");
		// LinkedList as Queue with FIFO
		Queue skillsQ = new LinkedList();
		skillsQ.add("Java");	// throws exceptions if add is not successfull
		skillsQ.offer(".Net");	// no exception, returns boolean value
		skillsQ.offer("Python");

		System.out.println(skillsQ.remove()); // reads and removes last element from the queue, throws exception if not successfull
		System.out.println(skillsQ.poll()); // no exception, returns boolean value

		System.out.println(skillsQ);

		System.out.println(skillsQ.element()); // reads last element w/o removing, throws exception if not successfull
		System.out.println(skillsQ.peek());	// reads last element w/o removing and no exception

		System.out.println(skillsQ);

		// LinkedList as DQueue with Double Side operations
		System.out.println("\nLinkedList as Double Sided Queue...");
		Deque skillsDQ = new LinkedList();
		skillsDQ.add("Java");
		skillsDQ.add("Python");
		skillsDQ.addLast(".Net");

		skillsDQ.offerFirst("Node JS");

		System.out.println(skillsDQ);

		System.out.println(skillsDQ.peekFirst());

		System.out.println(skillsDQ.peekLast());

		System.out.println(skillsDQ.pollFirst());
		System.out.println(skillsDQ);

		System.out.println(skillsDQ.pollLast());
		System.out.println(skillsDQ);

		// LinkedList as Stack with FILO / LIFO
		System.out.println("\nLinkedList as Stack...");
		Deque skillsStack = new LinkedList();
		skillsStack.push("Java");
		skillsStack.push("Python");
		skillsStack.push(".Net");

		// equivalent of push
//		skillsStack.offerFirst("Java");
//		skillsStack.offerFirst("Python");
//		skillsStack.offerFirst(".Net");

		System.out.println(skillsStack);

		System.out.println(skillsStack.pop());
		System.out.println(skillsStack.pop());

		// equivalent of pop
//		System.out.println(skillsStack.removeFirst());
//		System.out.println(skillsStack.removeFirst());

		System.out.println(skillsStack);
	}

}
