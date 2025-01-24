package com.examples.design.patterns.structural.bridge;

public class Circle extends Shape {
    private int x, y, radius;

    public Circle(int x, int y, int radius, DrawAPI drawAPI) {
        super(drawAPI);
        this.x = x;
        this.y = y;
        this.radius = radius;
    }

    public void draw() {
        if(drawAPI != null ) {
            drawAPI.drawCircle(radius, x, y);
        } else {
            System.out.println("Draw plain circle");
        }
    }
}
