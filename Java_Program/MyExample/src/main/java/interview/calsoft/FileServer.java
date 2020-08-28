package interview.calsoft;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

public class FileServer {
    public static void main(String[] args) throws Exception {
        final ExecutorService threads = Executors.newCachedThreadPool();
        ServerSocket ss = new ServerSocket(4444);
        AtomicInteger in =   new AtomicInteger();
        // running infinite loop for getting
        // client request
        while (true)
        {
            Socket socket = null;

             // socket object to receive incoming client requests
                socket = ss.accept();
                System.out.println(in.incrementAndGet());
                  threads.submit(  new RequestHadler(socket));

            }

        }
    }

