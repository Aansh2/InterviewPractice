package com.thread.Semaphore;

import java.util.concurrent.Semaphore;

/**
 * Created by nikhil on 13/3/18.
 */
public class PrintQueue {
    private final Semaphore semaphore;
    public PrintQueue(){
        semaphore=new Semaphore(1);
    }
}
