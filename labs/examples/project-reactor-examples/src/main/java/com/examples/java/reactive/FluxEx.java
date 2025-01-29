package com.examples.java.reactive;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import reactor.core.publisher.Flux;

public class FluxEx {
	public static void main(String[] args) {
		
		List<String> countries = new ArrayList<>();

		// PUSH
		// publisher
		Flux.just("India","UK","Australia","Japan","Germany","Italy")
		.log()
		// subscriber
		.subscribe(countries::add);  // item -> countries.add(item)

		System.out.println("No of countries - " + countries.size());
		
		
		// PULL
//		 Stream.of("India","UK","Australia","Japan")
//		.map(countries::add)
//		.count();
//
////		System.out.println("No of countries - " + count);
//
//		System.out.println("No of countries - " + countries.size());

	}

}
