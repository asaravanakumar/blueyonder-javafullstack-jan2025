package com.examples.java.reactive;

import reactor.core.publisher.Mono;

public class MonoEx {

	public static void main(String[] args) {		
		
		// Publisher
		Mono.just("India")
			.log()
		// Subscriber			
			.subscribe(System.out::println);		

	}
}
