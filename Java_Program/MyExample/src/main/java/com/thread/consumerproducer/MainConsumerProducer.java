package com.thread.consumerproducer;

/**
 * Created by nikhil on 13/3/18.
 */
public class MainConsumerProducer   {

    public static void main(String[] args) {
        EventStorage storage=new EventStorage();
        Producer producer=new Producer(storage);
        Thread thread1=new Thread(producer);
        Consumer consumer=new Consumer(storage);
        Thread thread2=new Thread(consumer);
        thread2.start();
        thread1.start();
    }

}
