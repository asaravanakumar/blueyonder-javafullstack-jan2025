package com.examples.java.annotation;

public class AnnotationDemo {
    public static void main(String[] args) {
        Car car = new Car("Ford", "F150", "2018");
        JsonSerializer serializer = new JsonSerializer();
        try {

            serializer.serialize(car);
        } catch (JsonSerializeException e) {
            System.out.println("ERROR: " + e.getMessage());
        }
    }
}
