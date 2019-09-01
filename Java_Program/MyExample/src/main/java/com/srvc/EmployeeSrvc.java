package com.srvc;

/**
 * Created by nikhil on 5/2/18.
 */
public interface EmployeeSrvc {
    default void getSelary() {
        System.out.println("getSelary ");
    }
      final static String a ="ssss";
    default   void display()
    {
        this.getSelary();
        System.out.println("display");
    }

    static int cube(int x){
        return x*x*x;
    }
     interface EmployeeInnerSrvc{

    }

     static class EmployeeInnerSrvcClass{

    }

}
