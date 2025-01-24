package com.examples.design.solid.l.good;


public class LspTest
{
    private static Shape getNewShape()
    {
        // it can be an object returned by some factory ...
        return new Rectangle();
//        return new Square();
    }

    public static void main (String args[])
    {
        Shape s = LspTest.getNewShape();

        s.setWidth(5);
        s.setHeight(10);
        // user knows that s it's a square.
        // It assumes that he's able to set the width and height as for the base class

        System.out.println(s.getArea());
    }
}
