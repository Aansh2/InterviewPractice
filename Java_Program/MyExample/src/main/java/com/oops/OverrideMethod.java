package com.oops;

public class OverrideMethod {
    // adding three integer values.
  /*  public int add(int a, int b, int c){
        System.out.println("    public int add(int a, int b, int c)");

        int sum = a+b+c;
        return sum;
    }*/

    // adding three double values.
    public double add(double a, double b, double c){
        System.out.println("add(double a, double b, double c){");
        double sum = a+b+c;
        return sum;
    }
    // adding three double values.
    public double add(int a, int b, double c){
        System.out.println("add(int a, int b, double c)");
        double sum = a+b+c;
        return sum;
    }
    // adding three double values.
    public double add(int a, int b, Double c){
        System.out.println("add(int a, int b, Double c)");
        double sum = a+b+c;
        return sum;
    }
    // adding three double values.
    public double add(Integer a, int b, Double c){
        System.out.println("add(Integer a, int b, Double c)");
        double sum = a+b+c;
        return sum;
    }
    public static void main(String[] args) {
        OverrideMethod overrideMethod= new OverrideMethod();
        overrideMethod.add(new Integer(1),1,Double.valueOf(1));
       // overrideMethod.add(new Integer(1),new Integer(1),Double.valueOf(1));

    }
}
