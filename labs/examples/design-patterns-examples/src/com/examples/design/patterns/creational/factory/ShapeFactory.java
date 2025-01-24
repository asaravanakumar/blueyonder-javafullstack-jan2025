package com.examples.design.patterns.creational.factory;

public class ShapeFactory {

    private static ShapeFactory instance = null;
    private ShapeFactory() {

    }

    public static ShapeFactory getInstance() {
        if(instance == null) {
            instance = new ShapeFactory();
        }
        return instance;
    }

    //use getShape method to get object of type shape
    public static Shape getShape(String shapeType){
        if(shapeType == null){
            return null;
        }
        if(shapeType.equalsIgnoreCase("CIRCLE")){
            return new Circle();

        } else if(shapeType.equalsIgnoreCase("RECTANGLE")){
            return new Rectangle();

        } else if(shapeType.equalsIgnoreCase("SQUARE")){
            return new Square();
        }

        return null;
    }
}
