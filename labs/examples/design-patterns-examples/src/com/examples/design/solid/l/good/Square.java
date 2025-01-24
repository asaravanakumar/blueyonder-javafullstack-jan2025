package com.examples.design.solid.l.good;

import com.examples.design.solid.l.bad.Rectangle;

public class Square extends Shape
{
    public void setWidth(int width){
        m_width = width;
        m_height = width;
    }

    public void setHeight(int height){
        m_width = height;
        m_height = height;
    }

    public int getArea(){
        return m_width * m_height;
    }
}
