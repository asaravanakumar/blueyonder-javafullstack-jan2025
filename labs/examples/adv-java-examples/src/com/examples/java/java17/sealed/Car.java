package com.examples.java.java17.sealed;

/**
 * All permitted subclasses must belong to the same module as the sealed class.
 * Every permitted subclass must explicitly extend the sealed class.
 * Every permitted subclass must define a modifier: final, sealed, or non-sealed.
 */
public non-sealed class Car extends Vehicle implements Serviceable {

    private int numberOfSeats;

    public Car(int numberOfSeats, String registrationNumber) {
        super(registrationNumber);
        this.numberOfSeats = numberOfSeats;
    }

    public int getNumberOfSeats() {
        return numberOfSeats;
    }

    @Override
    public int getMaxServiceIntervalInMonths() {
        return 12;
    }

}
