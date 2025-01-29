package com.examples.java.reactive;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

import reactor.core.publisher.Flux;

public class FluxWithBackPressureEx {
	public static void main(String[] args) {
		
		List<String> countries = new ArrayList<>();
		
		// PUSH
		// publisher
		Flux.just("India","UK","Australia","Japan","Germany","Italy")
		.log()
		// subscriber
		.subscribe(new Subscriber<String>() {
			
		    private Subscription s;
		    int onNextAmount;

			@Override
			public void onSubscribe(Subscription s) {
				System.out.println("onSubscribtion method called..");
				this.s = s;
				// making bounded subscribtion 
				s.request(2);
			}

			@Override
			public void onNext(String t) {
				System.out.println("onNext method called..");
				countries.add(t);
				System.out.println("Received - " + t);
		        onNextAmount++;
		        if (onNextAmount % 2 == 0) {
		            s.request(2);
		        }
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
