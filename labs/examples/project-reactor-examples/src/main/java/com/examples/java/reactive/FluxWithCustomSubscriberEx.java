package com.examples.java.reactive;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

import reactor.core.publisher.Flux;

public class FluxWithCustomSubscriberEx {
	public static void main(String[] args) {
		
		List<String> countries = new ArrayList<>();
		
		// PUSH
		// publisher
		Flux.just("India","UK","Australia","Japan")
		.log()
		// subscriber
		.subscribe(new Subscriber<String>() {

			@Override
			public void onSubscribe(Subscription s) {
				System.out.println("onSubscribtion method called..");
				// making bounded subscribtion to handle backpressure 
				s.request(2);
			}

			@Override
			public void onNext(String t) {
				System.out.println("onNext method called..");
				countries.add(t);
				System.out.println("Received - " + t);
			}

			@Override
			public void onError(Throwable t) {
				System.out.println("onError method called..");
				
			}

			@Override
			public void onComplete() {
				System.out.println("onComplete method called..");
				
			}
		});
		
		System.out.println("No of countries - " + countries.size());


	}

}
