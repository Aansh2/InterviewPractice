package com.calsoft.client;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.Serializable;
import java.net.Socket;
import java.nio.channels.FileChannel;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

import static java.lang.Math.toIntExact;

public class FileUploadClient implements Serializable {

    public static void main(String[] args) throws Exception {
        if(args.length < 1){
            throw  new Exception("File absolute path required in argument");
        }
        String filePath = args[0];
        int threadCount = 2;// actual can be threadCount + 1 ;
        String host = "127.0.0.1";
        int port = 4444;

        upload(filePath, threadCount, host, port);
    }

    private static void upload(String filePath, int threadCount, String host, int port) throws IOException {

        AtomicInteger threadCountForFile = new AtomicInteger();

        FileInputStream fileInputStream = new FileInputStream(filePath);
        FileChannel channel = fileInputStream.getChannel();
        long remaining_size = channel.size(); //get the total number of bytes in the file
        // Making chunk size of file using threads count
        long chunk_size = remaining_size / threadCount;

        //thread pool
        ExecutorService executor = Executors.newCachedThreadPool();

        long start_loc = 0;//file pointer
        int i = 0; //loop counter
        // UUID for mapping file chunks
        String uuid = UUID.randomUUID().toString();
        // List for  callable threads object
        List<Callable> uploadFileWorkerList = new ArrayList<Callable>();
        while (remaining_size >= chunk_size) {
            //launches a new thread
            // executor.submit(new UploadFileWorker(start_loc, toIntExact(chunk_size), channel, i, new Socket(host, 4444), uuid, thread ));
            uploadFileWorkerList.add(
                    new UploadFileWorker(start_loc, toIntExact(chunk_size), channel, i, new Socket(host, port), uuid,
                            threadCountForFile));
            remaining_size = remaining_size - chunk_size;
            start_loc = start_loc + chunk_size;
            threadCountForFile.incrementAndGet();
            i++;
        }

        threadCountForFile.incrementAndGet();

        //load the last remaining piece
        uploadFileWorkerList.add(
                new UploadFileWorker(start_loc, toIntExact(remaining_size), channel, i, new Socket(host, port), uuid,
                        threadCountForFile));

        uploadFileWorkerList.stream().forEach(e -> executor.submit(e));
        //shut down
        executor.shutdown();

        //Wait for all threads to finish
        while (!executor.isTerminated()) {

        }
        System.out.println("Finished all threads");
        fileInputStream.close();
    }

}
