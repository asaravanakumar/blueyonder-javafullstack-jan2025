package com.examples.java.java17.sealed;

public sealed interface Serviceable permits Car, Truck {

    int getMaxServiceIntervalInMonths();

    default int getMaxDistanceBetweenServicesInKilometers() {
        return 100000;
    }

}
