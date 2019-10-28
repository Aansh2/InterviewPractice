package com.thread.program;

import java.lang.management.ManagementFactory;
import java.lang.management.RuntimeMXBean;

// Java Program to illustrate the
// concept of interrupt() method
// while a thread does not stops working
class Interrupt {
  public static void main(String[] args) throws InterruptedException {
      printPID();
      interruptSleep();


  }
  static void interruptSleep() {
    Thread printer =
        new Thread() {
          @Override
          public void run() {
              printPID();
              //System.exit(0);


              try {
              for (int i = 0; i < 5; i++) {
                System.out.println("Child Thread executing");

                // Here current threads goes to sleeping state
                // Another thread gets the chance to execute
                // if is not blocked by any blocker like sleep, wait etc then   there
                // will be no exception just change Interrupted flag
                Thread.sleep(1000);
              }
            } catch (InterruptedException e) {
              System.out.println("InterruptedException occur");
            }
          }

          @Override
          public void start() {
            super.start();
            ;
          }
        };
    printer.start();

    // main thread calls interrupt() method on
    // child thread
      // System.exit(0);
    printer.interrupt();

    System.out.println("Main thread execution completes");
  }

 static void printPID(){
      RuntimeMXBean runtimeBean = ManagementFactory.getRuntimeMXBean();
      long pid = Long.valueOf(runtimeBean.getName().split("@")[0]);
      System.out.println("JVM PID  = " + pid);

  }
}
