package com.examples.design.patterns.creational.factory;

import java.util.Calendar;

public class FactoryPatternDemo {

    public static void main(String[] args) {
//        ShapeFactory shapeFactory = ShapeFactory.getInstance();

        //get an object of Circle and call its draw method.
        Shape shape1 = ShapeFactory.getShape("CIRCLE");

        //call draw method of Circle
        shape1.draw();

        //get an object of Rectangle and call its draw method.
        Shape shape2 = ShapeFactory.getShape("RECTANGLE");

        //call draw method of Rectangle
        shape2.draw();

        //get an object of Square and call its draw method.
        Shape shape3 = ShapeFactory.getShape("SQUARE");

        //call draw method of square
        shape3.draw();
    }
}
