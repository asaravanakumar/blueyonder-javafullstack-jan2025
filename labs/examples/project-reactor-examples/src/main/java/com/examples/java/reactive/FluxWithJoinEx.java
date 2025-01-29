package com.examples.java.reactive;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import reactor.core.publisher.Flux;

public class FluxWithJoinEx {

	public static void main(String[] args) {
		List<String> countries = new ArrayList<>();

		Flux.just("India", "China", "Australia", "Japan")
				.map(country -> country.toUpperCase())
				.log()
				.zipWith(Flux.fromIterable(Arrays.asList("IND","CHN","AUS","JPN")), (one, two) -> String.format("%s - %s", two, one))
				.subscribe(countries::add);
		
		System.out.println(countries);
	}
}
