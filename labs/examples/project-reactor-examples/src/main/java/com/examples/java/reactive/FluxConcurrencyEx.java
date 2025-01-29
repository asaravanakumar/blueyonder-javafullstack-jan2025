package com.examples.java.reactive;

import java.util.ArrayList;
import java.util.List;

import reactor.core.publisher.Flux;
import reactor.core.scheduler.Schedulers;

public class FluxConcurrencyEx {
	
	public static void main(String[] args) {
		
		List<String> countries = new ArrayList<>();
		
		Flux.just("India","UK","Australia","Japan")
		  .log()
		  .map(country -> country.toUpperCase())
		 // .subscribeOn(Schedulers.parallel()) 
		  .subscribe(countries::add);
		
		System.out.println(countries);	

	}

}
