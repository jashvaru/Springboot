package com.jash;

public class Alien {

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        System.out.println("Hi I am in setter method");
        this.age = age;
    }

    private int age;
    public Alien() {
        System.out.println("Alien Obj Created");
    }

    public void code() {
        System.out.println("coding....");
    }
}
