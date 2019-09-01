package com.model;

import com.srvc.EmployeeSrvc;

/**
 * Created by nikhil on 6/1/18.
 */
public   class Employee extends Person implements EmployeeSrvc , Runnable, Comparable{
    String name;
    int id;
    final static String PAN_CARD_NUMBER;
    static {
        PAN_CARD_NUMBER = "";
    }
    final   String PAN_CARD_NUMBER2;
      {
        PAN_CARD_NUMBER2 = "";
    }
    public Employee(String name, int id ) {
        super();
        this.name = name;
        this.id = id;

    }



    public static void staticMethod(String s ){

        System.out.print("Employey static method");

    }

    @Override
    public int compareTo(Object o) {
        Employee em = (Employee)o;
       return  em.name.compareToIgnoreCase(this.getName());

    }

    public static  class EmployeeInner{
        public void fun()  {
            System.out.println("Accessing Private Member of Outer: " );
        }

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


    /*@Override
    public boolean equals(Object o) {
        Employee em = (Employee) o;
       return  em.name.equalsIgnoreCase(this.name)? true :false;

    }*/

    @Override
    public int hashCode() {
       return this.id;
    }


    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Employee{");
        sb.append("name='").append(name).append('\'');
        sb.append(", id=").append(id);
        sb.append('}');
        return sb.toString();
    }
    @Override
    protected void finalize() throws Throwable {

    System.out.println("Im dying... good bye ...");
    }


    //@Override
    public void run() {
        System.out.println("Emplyee thread is running");
        try {
            Thread.sleep(3000);

            System.out.println("Emplyee thread is Awake");
            //Thread.currentThread().join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    public void p(Integer i) throws Exception{
        System.out.println("Emplyee  P    ");

    }
    public  void setAge(Integer i) throws Exception{
        System.out.println("setAge  Integer    "+i);

    }
    public  void setAge(int i) throws Exception{
        System.out.println("setAge  int    "+i);

    }
     public  void setAge(int i,Integer j) throws Exception{
        System.out.println("setAge(int i,Integer j)    "+i+" "+j);

    }
    public  String  setAge( float j, float i ) throws Exception{
        System.out.println("setAge( Integer j, int i )    "+j+" "+i);
        return "";

    }
    public   String  setAge( float j, double i ) throws Exception{
        System.out.println("setAge( Integer j, int i )    "+j+" "+i);
        return "";

    }
     public static  String  setPearsonName( int a, int b) throws Exception{
        System.out.println("Employee setAge( Integer j, int i )    "+a);
        return "";

    }

    public    void  personClassMethod( long a,long b , long d) throws Exception{
         final  int x= 5;

        System.out.println("setAge( long a,long b )    "+a);

    }


    public  void setObject(Object obj){

    }
    public  void setObject(Integer obj){

    }
    public  void setObject(String obj){

    }

}
