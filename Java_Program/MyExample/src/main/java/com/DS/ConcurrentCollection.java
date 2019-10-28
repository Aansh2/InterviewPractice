package com.DS;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ConcurrentCollection {
    public static void main(){


    }
    public static void init() throws InterruptedException {
        ConcurrentHashMap cunConcurrentHashMap = new ConcurrentHashMap<String, String>();
        cunConcurrentHashMap.get("");
        cunConcurrentHashMap.put("","");
        new ArrayBlockingQueue<String>(3);
        CountDownLatch latch =  new CountDownLatch(4);
        latch.countDown();
        latch.await();
        Lock lock = new ReentrantLock();
        lock.tryLock();

    }
}
