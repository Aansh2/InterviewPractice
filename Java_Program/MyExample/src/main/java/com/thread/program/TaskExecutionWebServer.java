package com.thread.program;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.ByteBuffer;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class TaskExecutionWebServer {
    private static final int NTHREADS = 100;
    private static final Executor exec
            = Executors.newFixedThreadPool(NTHREADS);
    public static void main(String[] args) throws IOException {
        ServerSocket socket = new ServerSocket(8080);
        while (true) {
            System.out.println("in while");

            final Socket connection = socket.accept();
            System.out.println("Accepted");

            Runnable task = new Runnable() {
                public void run() {
                    try {
                        System.out.println("in run");

                        ObjectOutputStream oos = new ObjectOutputStream(connection.getOutputStream());
                        //write object to Socket
                        oos.writeObject("Hi Client ");
                        oos.close();
                        connection.close();
                     } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            };
            exec.execute(task);
        }
    }
}
