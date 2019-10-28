package com.thread.program;

import java.util.concurrent.atomic.AtomicLong;

public class Miscellaneous {

  public static void main(String[] arg) throws  Exception {
    communicateObj();

  }

  /*
   * Race condition
   * Read-modify-write operations, read-modify-write operations
   * (like increment) must always be atomic
   */
  public class LazyInitRace {
    private String instance = null;

    public String getInstance() {
      if (instance == null) instance = new String();
      return instance;
    }
  }

   /* good example to count */
  public class CountingFactorizer {
    private final AtomicLong count = new AtomicLong(0);

    public long getCount() {
      return count.get();
    }

    public void service() {
      count.incrementAndGet();
    }
  }
/* --------------------------------  start  -------------------------------------*/
  public static void communicateObj() throws InterruptedException {
    Object lock = new Object();
    WaitNotify wn =  new WaitNotify(lock);
    Thread thread1 = new Thread(new Runnable() {
      @Override
      public void run() {
        wn.releaseThisLockAndWait1();
      }
    });
    Thread thread2 = new Thread(new Runnable() {
      @Override
      public void run() {
        wn.releaseThisLockAndWait2();
      }
    });
    Thread thread3 = new Thread(new Runnable() {
      @Override
      public void run() {
        wn.releaseThisLockAndWait2();
      }
    });
    Thread notifyThread = new Thread(new Runnable() {
      @Override
      public void run() {
        wn.notifyThis();
      }
    });
    System.out.println("Started");
    thread1.start();
    thread2.start();
    thread3.start();

    Thread.currentThread().sleep(1000);
    System.out.println("Awaiked");
    notifyThread.start();

    Thread.currentThread().sleep(10000);

  }


  // kind of producer and consumer
  public static class WaitNotify {
    public boolean flag = true;
    public Object lock = null;
    WaitNotify(Object lock){
      this.lock = lock;
    }
    public void releaseThisLockAndWait1(){
        synchronized (lock){
          while (flag){
            try {
              System.out.println("Going to wait1");
              lock.wait();
              System.out.println("step continue1");
            } catch (InterruptedException e) {
              e.printStackTrace();
            }
            flag = false;
          }

        }
    }
    public void releaseThisLockAndWait2(){
      synchronized (lock){
        while (flag){
          try {
            System.out.println("Going to wait2");
            lock.wait();
            System.out.println("step continue2");
          } catch (InterruptedException e) {
            e.printStackTrace();
          }
          flag = false;
        }

      }
    }
    public void notifyThis(){
      synchronized (lock){
        System.out.println("Going to Notify");
        lock.notifyAll();
      }
    }
  }

  /* --------------------------------  end  -------------------------------------*/

}
