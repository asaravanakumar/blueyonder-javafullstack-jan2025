package com.examples.design.patterns.behavioral.visitor;

public class ComputerPartDisplayVisitor implements ComputerPartVisitor {

    public void visit(ComputerPart part) {

        System.out.println("Displaying computer part");
    }

//    @Override
//    public void visit(Computer computer) {
//        System.out.println("Displaying Computer.");
//    }
//
//    @Override
//    public void visit(Mouse mouse) {
//        System.out.println("Displaying Mouse.");
//    }
//
//    @Override
//    public void visit(Keyboard keyboard) {
//        System.out.println("Displaying Keyboard.");
//    }
//
//    @Override
//    public void visit(Monitor monitor) {
//        System.out.println("Displaying Monitor.");
//    }
}

