package com.examples.design.solid.o.good;

// Open-Close Principle - Good example
public class GraphicEditor {

    public static void main(String[] args) {
        GraphicEditor editor = new GraphicEditor();
        Shape rect = new Square();
        editor.drawShape(rect);
    }
    public void drawShape(Shape s) {
        s.draw();
    }
}
