package com.model;

/**
 * Created by nikhil on 7/1/18.
 */
public class HelloIndia {
    private String message = "Hello India";

    public void sayHello(){
        System.out.println(message);
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
