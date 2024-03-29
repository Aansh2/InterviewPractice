package com.calsoft.server;

import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicInteger;

// Callable class which run in new thread to download file chunk 
public class FileRequestWorker implements Callable<Boolean> {

    private Socket socket = null;
   private String fileDirectory ;

    public FileRequestWorker(Socket socket, String fileDirectory) {
        this.socket = socket;
        this.fileDirectory = fileDirectory;
 
    }

    @Override public Boolean call() {
        int bytesRead;

        System.out.println("Created thread ....");
        int whileLoop = 0;

        try {
            DataInputStream inputStreamFirst = new DataInputStream(socket.getInputStream());

            // Send first message

            String s = inputStreamFirst.readUTF();
            String[] uuidAndSequesceAndThreadCount = s.split(" ");
            String uuid = uuidAndSequesceAndThreadCount[0];
            String sequence = uuidAndSequesceAndThreadCount[1];

            int totalThread = Integer.valueOf(uuidAndSequesceAndThreadCount[2]);

            System.out.println("First Reading ...." + s);

            byte[] buffer = new byte[1024];
            long size = inputStreamFirst.readLong();
            InputStream inputStream = socket.getInputStream();
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            while (size > 0
                    && (bytesRead = inputStreamFirst.read(buffer, 0, (int) Math.min(buffer.length, size))) != -1) {
                byteArrayOutputStream.write(buffer, 0, bytesRead);
                size -= bytesRead;
            }

            inputStream.close();

            if (ServerFileData.getMap().get(uuid) == null) {
                ServerFileData.getMap()
                        .put(uuid, new ArrayList<>(
                                Collections.nCopies(totalThread, null)));
            }
            ServerFileData.getMap()
                    .get(uuid)
                    .set(Integer.valueOf(sequence), byteArrayOutputStream.toByteArray());
            if (ServerFileData.getAtomicInteger().get(uuid) == null) {
                ServerFileData.getAtomicInteger()
                        .put(uuid,
                                new AtomicInteger(totalThread));
            }
            Integer threadComplitionCount =
                    ServerFileData.getAtomicInteger().get(uuid).decrementAndGet();
             if (threadComplitionCount == 0) {
                List<byte[]> fileInArray = ServerFileData.getMap().get(uuid);
                writeFile(fileInArray, uuid);
                ServerFileData.getMap().remove(uuid);
                ServerFileData.getAtomicInteger().remove(uuid);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return true;
    }

    private void writeFile(List<byte[]> fileInArray, String fileName) {
        System.out.println("File writing in the path " + fileDirectory + "/" + fileName);

        try (FileOutputStream stream = new FileOutputStream(fileDirectory + "/" + fileName)) {
            fileInArray.stream().forEach((bt) -> {
                try {
                    stream.write(bt);
                } catch (IOException e) {
                    e.printStackTrace();
                }

            });
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
