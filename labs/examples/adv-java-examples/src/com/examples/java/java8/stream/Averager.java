package com.examples.java.java8.stream;

import java.util.function.DoubleConsumer;

class Averager implements DoubleConsumer {
	private double total = 0;
	private int count = 0;

	public double average() {
		return count > 0 ? ((double) total) / count : 0;
	}

	public void accept(double i) {
		total += i;
		count++;
	}

	public void combine(Averager other) {
		total += other.total;
		count += other.count;
	}
}
