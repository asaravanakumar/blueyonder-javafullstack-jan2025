package com.examples.java.java17.sealed;

/**
 * Sealed classes enables more fine-grained inheritance control in Java.
 * Sealing allows classes and interfaces to define their permitted subtypes.
 */
public class SealedClassDemo {
    public static void main(String[] args) {
        Car car = new Car(5, "PP1234");
        System.out.println(car.getNumberOfSeats() + " " + car.getRegistrationNumber() + " " + car.getMaxServiceIntervalInMonths());

        Truck truck = new Truck(20, "PP9876");
        System.out.println(truck.getLoadCapacity() + " " + truck.getRegistrationNumber() + " " + car.getMaxServiceIntervalInMonths());

        Bus bus = new Bus(50, "PP7777");
        System.out.println(bus.getSeatCapacity() + " " + bus.getRegistrationNumber());

        Vehicle car1 = new Car(7, "PP2222");
        System.out.println(car1.getRegistrationNumber());

        Serviceable car2 = new Car(5, "PP3333");
        System.out.println(car2.getMaxServiceIntervalInMonths() + " " + car2.getMaxDistanceBetweenServicesInKilometers());

    }
}
