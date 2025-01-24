package com.examples.design.solid.o.bad;

// Open-Close Principle - Bad example
public class GraphicEditor {

    public void drawShape(Shape s) {
        if (s.m_type==1)
            drawRectangle((Rectangle) s);
        else if (s.m_type==2)
            drawCircle((Circle) s);
    }
    public void drawCircle(Circle r) {}
    public void drawRectangle(Rectangle r) {}
}

