package com.examples.java.reactive;

import reactor.core.publisher.Flux;

public class FluxWithEmptyDataEx {
	public static void main(String[] args) {
		
		// publisher
		Flux.empty()
		.log()
		// subscriber
		.subscribe();
	}

}
