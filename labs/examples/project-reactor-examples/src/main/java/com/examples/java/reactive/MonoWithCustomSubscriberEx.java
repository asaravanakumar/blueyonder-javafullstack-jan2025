package com.examples.java.reactive;

import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

import reactor.core.publisher.Mono;

public class MonoWithCustomSubscriberEx {

	public static void main(String[] args) {
		
		// Publisher
		Mono.just("India")
			.log()
		// Subscriber			
			.subscribe(new Subscriber<String>() {

				@Override
				public void onSubscribe(Subscription s) {
					System.out.println("onSubscribtion method called..");
					// making unbounded subscribtion 
					s.request(Long.MAX_VALUE);
					//s.request(0);
				}

				@Override
				public void onNext(String t) {
					System.out.println("onNext method called..");
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
		
	}
}
