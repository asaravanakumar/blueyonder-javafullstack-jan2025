package com.examples.design.patterns.structural.proxy;

public class RealImage implements Image {

    private String fileName;

    public RealImage(String fileName){
        System.out.println("Real constructor...");
        this.fileName = fileName;
        loadFromDisk(fileName);
    }

    @Override
    public void display() {
        System.out.println("Displaying " + fileName);
    }

    private void loadFromDisk(String fileName){
        System.out.println("Loading " + fileName);
    }
}
