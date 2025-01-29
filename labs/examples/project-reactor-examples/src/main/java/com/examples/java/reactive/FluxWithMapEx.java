package com.examples.java.reactive;

import java.util.ArrayList;
import java.util.List;

import reactor.core.publisher.Flux;

public class FluxWithMapEx {

	public static void main(String[] args) {
		List<String> countries = new ArrayList<>();

		Flux.just("India", "UK", "Australia", "Japan")
				.map(country -> country.toUpperCase())
				.log()
				.subscribe(countries::add); // item -> countries.add(item)

		System.out.println("Countries List - " + countries);
	}

}
