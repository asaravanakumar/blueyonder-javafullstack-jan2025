package com.examples.java.reactive;

import reactor.core.publisher.Mono;

public class MonoWithEmptyDataEx {

	public static void main(String[] args) {		
		
		// Publisher
		//Mono.justOrEmpty(null)
		Mono.empty()
			.log()
		// Subscriber			
			.subscribe(System.out::println);		

	}
}
