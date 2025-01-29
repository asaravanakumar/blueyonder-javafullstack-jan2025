package com.examples.java.reactive;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import reactor.core.publisher.Flux;

public class FluxErrorEx {
	public static void main(String[] args) {
		
		List<String> countries = new ArrayList<>();
		
		// PUSH
		// publisher
		Flux.just("India","UK","Australia","Japan")
		//.map(String::toUpperCase)
		.map(country -> {if(country.equals("Japan")) throw new RuntimeException("Invalid Country Name"); return country.toUpperCase();})
		.log()
		// subscriber
		.subscribe(countries::add, error -> System.out.println("Error Occured: " + error.getMessage()));  // item -> countries.add(item)
		
		System.out.println("Countries List - " + countries);


	}

}
