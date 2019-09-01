package com.thread.threadexecutors;

/**
 * Created by nikhil on 13/3/18.
 */
public class ExecutorMain {
    public static void main(String[] args) {
        Server server=new Server();
        for (int i=0; i<300; i++) {
            Task task = new Task("Task " + i);
            server.executeTask(task);
        }
        server.endServer();
    }
}
