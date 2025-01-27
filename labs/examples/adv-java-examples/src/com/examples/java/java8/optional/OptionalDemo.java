package com.examples.java.java8.optional;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class OptionalDemo {

	public static void main(String[] args) {
		
		// check whether cities present to print otherwise show error message
		if(getCities().isPresent()) {
			List<String> cities = getCities().get();		
			System.out.println(cities.get(0));		
		} else {
			System.out.println("No cities found");
		}
		
		// gets cities if present otherwise creates new list of cities
		List<String> cities1 = getCities().orElse(Arrays.asList("Delhi"));
		System.out.println(cities1);

		// Supported in Java 11
		// returns cities optional if present otherwise creates optional
//		Optional<List<String>> cities2 = getCities().or(() -> Optional.of(Arrays.asList("Hyderabad","Noida")));
//		System.out.println(cities2);
				
		// returns cities optional if matches to given filter condition otherwise empty optional
		Optional<List<String>> cities3 = getCities().filter(item -> item.contains("Noida") || item.contains("Mumbai")); 
		System.out.println(cities3);		
		
		// throws error if optional is empty
		getCities().orElseThrow(RuntimeException::new); // () -> new RuntimeException()

	}
	
//	private static List<String> getCities() {
////		return Arrays.asList("Bengaluru", "Mumbai", "Pune", "Delhi", "Kolkata", "Chennai");
//		return null;
//	}
	
//	private static String getCity() {
////		return "Bengaluru";
//		return null;
//	}
	
	private static Optional<List<String>> getCities() {
		Optional<List<String>> cities = Optional.of(Arrays.asList("Bengaluru", "Mumbai", "Pune", "Delhi", "Kolkata", "Chennai"));
//		Optional<List<String>> cities = Optional.empty();
		return cities;
	}
	
	private static Optional<String> getCity() {
		Optional<String> city = Optional.of("Bengaluru");	
//		Optional<String> city = Optional.empty();
		return city;
	}

}
