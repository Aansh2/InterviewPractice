package com.thread.threadexecutors;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * Created by nikhil on 13/3/18.
 */
public class Server {
    private ThreadPoolExecutor executor;

    public Server(){
       // executor = (ThreadPoolExecutor)Executors.newFixedThreadPool(20);
        executor = (ThreadPoolExecutor)Executors.newCachedThreadPool();
    }
    public void executeTask(Task task){
        System.out.printf("Server: A new task has arrived\n");
        executor.execute(task);
        System.out.printf("Server: Pool Size: %d\n",executor.
                getPoolSize());
        System.out.printf("Server: Active Count: %d\n",executor.
                getActiveCount());
        System.out.printf("Server: Completed Tasks: %d\n",executor.
                getCompletedTaskCount());
    }
    public void endServer() {
        executor.shutdown();
    }
}
