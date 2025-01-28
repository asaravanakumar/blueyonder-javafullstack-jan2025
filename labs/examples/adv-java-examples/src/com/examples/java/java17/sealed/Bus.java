package com.examples.java.java17.sealed;

public non-sealed class Bus extends Vehicle {

    private int seatCapacity;

    public Bus(String registrationNumber) {
        super(registrationNumber);
    }

    public Bus(int seatCapacity, String registrationNumber) {
        super(registrationNumber);
        this.seatCapacity = seatCapacity;
    }

    public int getSeatCapacity() {
        return seatCapacity;
    }

    public void setSeatCapacity(int seatCapacity) {
        this.seatCapacity = seatCapacity;
    }
}
