package com.thread.program;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.TimeUnit;

public class CyclicBarrieR {
  public static void main(String[] args) throws BrokenBarrierException, InterruptedException {
     testCyclicBarrieR();
  }

  static  void testCyclicBarrieR() throws BrokenBarrierException, InterruptedException {
    CyclicBarrier barrier = new CyclicBarrier(3);
    new Thread(new Resource(barrier, "1", 2000)).start();
    new Thread(new Resource(barrier, "2", 5000)).start();
   }

  static class Resource implements  Runnable{
      private  CyclicBarrier cyclicBarrier = null;
      String name ;
      long wait;

      Resource(CyclicBarrier cyclicBarrier, String threadName, long wait){
          this.cyclicBarrier = cyclicBarrier;
          name = threadName;
          this.wait = wait;

      }

      @Override
      public void run() {
          try {
              Thread.currentThread().sleep(wait);
              System.out.println("Thread Name is "+ name +" is going to enter in  barrier");
              cyclicBarrier.await();
              System.out.println("Going ahead "+name);

          } catch (InterruptedException e) {
              e.printStackTrace();
          } catch (BrokenBarrierException e) {
              e.printStackTrace();
          }
      }
  }

}
