package com.model;

import java.io.IOException;

/**
 * Created by nikhil on 3/4/18.
 */
public class OverLoading {
  //1. Return type does not matter
   // 2.
    public void set(Object obj){
        System.out.print("obj");
    }
    public void set(String obj){
        System.out.print("String");
    }
    public void set(String obj,String obj2){
        System.out.print("String");
    }
    public String set(Object obj,String a){
        System.out.print("Object obj,String a");
        return "";
    }
    public String set(String obj,Object a)throws IOException{
        System.out.print("String obj,Object a");
        return "";
    }

    public String set(Float obj,int a) throws Exception {
        System.out.print("Float obj,int a)");
        return "";
    }

    public static  void  main(String [] arg) throws Exception {
        OverLoading overLoading =  new OverLoading();
        overLoading.set("654564","String");
       overLoading.set(25f,23);



    }

}
