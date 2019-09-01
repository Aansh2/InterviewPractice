package com.model;

/**
 * Created by nikhil on 4/2/18.
 */
public class Person extends  Object{
    String fisrtName ;
    String lastName;
    String address;

    protected Person() {
    }

    final static public void staticMethod(){
        System.out.print("Person static method");
    }



    public String getFisrtName() {
        return fisrtName;
    }

    public void setFisrtName(String fisrtName) {
        this.fisrtName = fisrtName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    private void p(int i){
        System.out.println("person  P    ");

    }
    public static  String  setPearsonName( int a, int b) throws Exception{
        System.out.println("setAge( Integer j, int i )    "+a);
        return "";

    }
    public   String  setPearsonName( long a,long b ) throws Exception{
        System.out.println("setAge( long a,long b )    "+a);
        return "";

    }


    public   String  personClassMethod( long a,long b ) throws Exception{
        System.out.println("setAge( long a,long b )    "+a);
        return "";

    }
}
