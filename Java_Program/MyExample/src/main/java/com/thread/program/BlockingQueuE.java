package com.thread.program;


import java.util.Date;
import java.util.LinkedList;

public class BlockingQueuE {
    int limit = 0 ;
    LinkedList list = new LinkedList<Long>();
    public static void main(String[] arg) throws InterruptedException {
        BlockingQueuE blockingQueueMy = new BlockingQueuE(20);
      Thread thread1 =   new Thread(new Runnable() {
            @Override
            public void run() {
                while(true) {
                    try {
                        blockingQueueMy.enqueue(new Date().getTime());
                        Thread.currentThread().sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });
        Thread thread2 =   new Thread(new Runnable() {
            @Override
            public void run() {
                while(true) {
                    try {
                        blockingQueueMy.dequeue();
                        Thread.currentThread().sleep(10);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });
        thread1.start();
        thread2.start();
        //Thread.currentThread().sleep(100000);
    }

    BlockingQueuE(int limit){
        this.limit = limit;
    }

    public synchronized void enqueue(Long s) throws InterruptedException {
        if(list.size() == limit){
            System.out.println("List is full, Waiting for consumer ");
            wait();
        }
        System.out.println("Adding");

        this.list.add(s);
        if(list.size() == limit)
            this.notifyAll();
    }
    public synchronized Object dequeue() throws InterruptedException {
        if(this.list.size() < 1 ){
            System.out.println("List is Empty, Waiting for Producer ");
            wait();
        }
        Long lst = (Long) this.list.removeLast();
        System.out.println("Removing -- "+lst);
       return  lst;

    }
}
