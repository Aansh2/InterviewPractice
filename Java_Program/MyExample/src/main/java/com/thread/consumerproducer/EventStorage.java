package com.thread.consumerproducer;

import java.util.Date;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by nikhil on 13/3/18.
 */
public class EventStorage {
    private int maxSize;
    private LinkedList<Date> storage;

    public EventStorage(){
        maxSize = 10;
        storage = new LinkedList<>();

    }

    public synchronized void set(){

        while(storage.size() == maxSize){
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        storage.offer(new Date());
        System.out.printf("Set: %d"+System.lineSeparator(),storage.size()) ;
        notifyAll();
    }
    public synchronized void get(){
        while (storage.size()==0){
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.printf("Get: %d: %s"+System.lineSeparator(),storage.
                size(),((LinkedList<?>)storage).poll());
        notifyAll();
    }
}
