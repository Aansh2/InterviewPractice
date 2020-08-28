package com.calsoft.server;

import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

public class FileServer {
    public static String firstNonRepeatingLetter( String str ) {
        if(str.length() == 1){
            return str;
        }


        for(int i =0 ; i < str.length() ; i++){
            char c = str.charAt(i);
            boolean f = true;
            for(int j =i+1 ; j < str.length() ; j++){
                char c2 = str.charAt(j);
                if(c == c2 ){
                    f = false;
                    break;
                }
            }
            if(f){
                return String.valueOf(c) ;
            }
        }
        return null;
    }
    public static void main(String[] args) throws Exception {
       String a =  firstNonRepeatingLetter("moonmen");
        if(args.length < 1){
            throw  new Exception("Directory required in argument to download file ");
        }
        String fileDirectory = args[0];
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
                // creating thread
                  threads.submit(  new FileRequestWorker(socket, fileDirectory));

            }

        }
    }

