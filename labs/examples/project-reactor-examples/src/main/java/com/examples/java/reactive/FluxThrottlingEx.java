package com.examples.java.reactive;

import reactor.core.publisher.ConnectableFlux;
import reactor.core.publisher.Flux;

public class FluxThrottlingEx {
	
	public static void main(String[] args) {
		
		
		ConnectableFlux<Object> publish = Flux.create(fluxSink -> {
		    while(true) {
		        fluxSink.next(System.currentTimeMillis());
		    }
		})
		.publish();
		
		publish.subscribe(System.out::println); 
		
		publish.connect();
	}

}
