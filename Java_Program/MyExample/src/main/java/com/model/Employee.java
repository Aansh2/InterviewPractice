package com.model;

/**
 * Created by nikhil on 6/1/18.
 */
public class Employee {
    String name;
    int id;

    public Employee(String name, int id) {
        this.name = name;
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


    @Override
    public boolean equals(Object o) {
        Employee em = (Employee) o;
       return  em.name.equalsIgnoreCase(this.name)? true :false;

    }

    @Override
    public int hashCode() {
       return this.id;
    }
}
