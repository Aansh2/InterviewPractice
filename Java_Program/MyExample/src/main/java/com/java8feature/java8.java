package com.java8feature;

/**
 * Created by nikhil on 28/2/18.
 */
public class java8 {

    @FunctionalInterface
    interface Sayable{
        void say();
    }

    public static void saySomething(){
        System.out.println("Hello, this is static method.");
    }
    public static void main(String[] args) {
        // Referring static method
        Sayable sayable = java8::saySomething;
        // Calling interface method
        sayable.say();
    }
}
