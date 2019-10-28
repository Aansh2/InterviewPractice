package com.thread.program;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class LogWriter {

  static BlockingQueue<String> blockingQueue = new ArrayBlockingQueue(10);
  private static LogWriter logger = null;

  static {
    System.out.println("Static: creating logger ");
    logger = new LogWriter();
    new Thread(new Log()).start();
  }

  private LogWriter() {}

  public static void main(String[] args) throws Exception {
      Runtime.getRuntime().addShutdownHook(new Thread() {
          public void run() {
              System.out.println("Java is going to shutdown...");
          }
      });
    LogWriter.getInstance().log("HII>>>>>>>>>>>>>>>>");
    Thread.currentThread().sleep(4000);
    LogWriter.getInstance().log("Nikhil");
  }

  public static LogWriter getInstance() {
    return logger;
  }

  public void log(String msg) {
    try {
      blockingQueue.put(msg);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
  }

  private static void doLog() {
    while (true) {
      try {
        System.out.println("In while loop");

        Thread.currentThread().sleep(1000);
        System.out.println(blockingQueue.take());
        throw new RuntimeException("Error ");
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    }
  }

  static class Log implements Runnable, Thread.UncaughtExceptionHandler {

    @Override
    public void run() {
       Thread.currentThread().setUncaughtExceptionHandler(this);
      System.out.println("Logger log started ...");

      LogWriter.doLog();
    }

    @Override
    public void uncaughtException(Thread t, Throwable e) {
      System.out.println("Caught Exception....");
    }
  }
}
