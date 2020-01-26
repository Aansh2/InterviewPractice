package com.thread.threadexecutors;

import java.util.concurrent.*;

import static java.util.concurrent.TimeUnit.NANOSECONDS;

/** Created by nikhil on 13/3/18. */
public class ExecutorMain {
  public static void main(String[] args) throws ExecutionException, InterruptedException {
    executors();
  }

  public static void mainEn() {
    Server server = new Server();
    for (int i = 0; i < 300; i++) {
      Task task = new Task("Task " + i);
      server.executeTask(task);
    }
    server.endServer();
  }

  public static void executors() throws ExecutionException, InterruptedException {

    ExecutorService executorService = Executors.newSingleThreadExecutor();
    new ThreadPoolExecutor(1, 1, 0L, TimeUnit.MILLISECONDS, new LinkedBlockingQueue<Runnable>());
    executorService = Executors.newFixedThreadPool(2);

    new ThreadPoolExecutor(0, Integer.MAX_VALUE, 60L,
            TimeUnit.SECONDS, new SynchronousQueue<Runnable>());
    executorService = Executors.newCachedThreadPool();
     /* super(corePoolSize, Integer.MAX_VALUE, 0, NANOSECONDS,
              new ScheduledThreadPoolExecutor.DelayedWorkQueue());*/
    executorService = Executors.newScheduledThreadPool(2);
    executorService = Executors.newSingleThreadScheduledExecutor();

    Future<String> f2 =
        (Future<String>)
            executorService.submit(
                () -> {
                  System.out.println("in Thread 1 ");
                  try {
                    Thread.sleep(10000);
                    System.out.println("end Thread 1 ");
                  } catch (InterruptedException e) {
                    e.printStackTrace();
                  }
                });
    executorService.submit(
        () -> {
          System.out.println("in Thread 2 ");
          try {
            Thread.sleep(10000);
            System.out.println("end Thread 2 ");

          } catch (InterruptedException e) {
            e.printStackTrace();
          }
        });

    executorService.shutdown();
  }
}
