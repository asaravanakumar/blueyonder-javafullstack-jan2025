package com.examples.java.java17.sealed;

/**
 *
 */
public abstract sealed class Vehicle permits Car, Truck, Bus {

    protected final String registrationNumber;

    public Vehicle(String registrationNumber) {
        this.registrationNumber = registrationNumber;
    }

    public String getRegistrationNumber() {
        return registrationNumber;
    }

}
