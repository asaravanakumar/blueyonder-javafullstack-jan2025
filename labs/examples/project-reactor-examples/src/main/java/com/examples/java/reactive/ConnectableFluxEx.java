package com.examples.java.reactive;

import java.time.Duration;

import reactor.core.publisher.ConnectableFlux;
import reactor.core.publisher.Flux;

public class ConnectableFluxEx {
	
	public static void main(String[] args) {
		
		
		ConnectableFlux<Object> publish = Flux.create(fluxSink -> {
		    while(true) {
		        fluxSink.next(System.currentTimeMillis());
		    }
		})
		.sample(Duration.ofSeconds(2))
		.publish();
		
		publish.subscribe(System.out::println); 
		
		publish.connect();
	}

}
