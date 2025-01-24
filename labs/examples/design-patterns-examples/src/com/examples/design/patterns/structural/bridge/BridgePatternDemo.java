package com.examples.design.patterns.structural.bridge;

public class BridgePatternDemo {
    public static void main(String[] args) {
        Shape redCircle = new Circle(100,100, 10, new RedCircle());
        Shape greenCircle = new Circle(100,100, 10, new GreenCircle());
        Shape plainCircle = new Circle(100,100, 10, null);



        redCircle.draw();
        greenCircle.draw();
        plainCircle.draw();
    }
}
