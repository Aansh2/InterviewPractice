package com.thread.program;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadDeadlock {
    static  ExecutorService executors =  Executors.newSingleThreadExecutor();
    static int i = 0;
    public static void main(String[] args) {

       executors.submit(new ThreaD());

  }

     static class ThreaD implements Callable<String> {

         @Override
         public String call() throws Exception {
             System.out.println(i);
             i++;
              executors.submit(this);
             executors.submit(this);

             return "Done";
         }
     }


}
