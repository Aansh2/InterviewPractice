package com.calsoft.client;

import java.io.DataOutputStream;
import java.net.Socket;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicInteger;

public class UploadFileWorker implements Callable<Boolean> {
    private FileChannel channel;
    private long startLocation;
    private int size;
    private int sequence;
    private Socket socket;
    private String uuid;
    private AtomicInteger threadCount ;

    public UploadFileWorker(long startLocation, int size, FileChannel channel, int sequence, Socket socket, String uuid, AtomicInteger thread ){
            this.startLocation = startLocation;
            this.size = size;
        this.channel = channel;
            this.sequence = sequence;
        this.socket = socket;
        this.threadCount = thread;
        this.uuid = uuid;
        }


    @Override
    public Boolean call() throws Exception {
        //allocate memory
        ByteBuffer buff = ByteBuffer.allocate(size);

        //Read file chunk
        channel.read(buff, startLocation);
        DataOutputStream dOut = new DataOutputStream(socket.getOutputStream());

        // Send first message
        // Metadata of file and thread
        System.out.println(uuid +" "+sequence+" " + threadCount.get() + " "+buff.array().length);
        dOut.writeUTF( uuid +" "+sequence+" " + threadCount.get());
        dOut.writeLong(buff.array().length);
        dOut.write(buff.array(), 0, buff.array().length);

        dOut.flush();
        dOut.close();



        return true;
    }
}
