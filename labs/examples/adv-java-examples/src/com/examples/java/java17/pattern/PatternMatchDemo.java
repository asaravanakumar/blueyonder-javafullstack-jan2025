package com.examples.java.java17.pattern;

public class PatternMatchDemo {
    public static void main(String[] args) {
        Person employee = new Employee(123, "Mathews");
        System.out.println(getId(employee));

        Person manager = new Manager(777, "Robin");
        System.out.println(getId(manager));
    }
    public static int getId(Person person) {
        if (person instanceof Employee e) {
            return e.getEmployeeId();
        }
        else if (person instanceof Manager m) {
            return m.getManagerId();
        }
        return -1;
    }
}
abstract class Person {
    String name;
    String getName() {
        return name;
    }
}
final class Employee extends Person {
    String name;
    int id;
    Employee(int id, String name){
        this.id = id;
        this.name = name;
    }
    int getEmployeeId() {
        return id;
    }
}
final class Manager extends Person {
    int id;
    Manager(int id, String name){
        this.id = id;
        this.name = name;
    }
    int getManagerId() {
        return id;
    }
}

