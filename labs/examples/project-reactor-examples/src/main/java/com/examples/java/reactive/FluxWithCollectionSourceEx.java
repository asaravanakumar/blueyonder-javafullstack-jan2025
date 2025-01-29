package com.examples.java.reactive;

import java.util.ArrayList;
import java.util.List;

import reactor.core.publisher.Flux;

public class FluxWithCollectionSourceEx {
	
	public static void main(String[] args) {
		List<String> srcCountries = new ArrayList<>();
		srcCountries.add("India");
		srcCountries.add("UK");
		srcCountries.add("Australia");
		
		Flux.fromIterable(srcCountries)
		.log()
		.subscribe(System.out::println);
	}

}
