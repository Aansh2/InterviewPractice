package com.thread;

import com.thread.classes.Calculator;

import java.util.Date;
import java.util.UUID;
import java.util.concurrent.ThreadFactory;

/**
 * Created by nikhil on 27/2/18.
 */
public class MyThreadMain {
    public static void main(String args[]) throws Exception{
        threadGroup();
    }


    public void  makeTheadByFactory(){
        ThreadFactory factory =    new ThreadFactory(){
            @Override
            public  Thread newThread(Runnable r){
                return new Thread(r);
            }
        };

    }

    public static void threadGroup() throws InterruptedException {
        ThreadGroup pg = new ThreadGroup("pg");
        ThreadGroup cg = new ThreadGroup("cg");

        Runnable run =  new Runnable() {

            @Override
            public void run() {
                String uuid  = UUID.randomUUID().toString();


                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName()+" : "+uuid);

                // Integer.parseInt("qw");
            }
        };
        Thread t = new Thread(pg,run );
        Thread t2 = new Thread(pg,run );
        Thread t3 = new Thread(pg,run );
        Thread t4 = new Thread(cg,run );
        t.setUncaughtExceptionHandler(new Thread.UncaughtExceptionHandler() {
            @Override
            public void uncaughtException(Thread t, Throwable e) {
                System.out.print(t.getName());
            }
        });

        t.start();
        t2.start();
        t3.start();
        t4.start();
       Thread[] ac =  new Thread[pg.activeCount()];
       int count =  pg.enumerate(ac);
        for (int i = 0; i < count; i++) {
            System.out.println("Thread " + ac[i].getName() + " found");
        }

        t.join();

    }

    public static void exceptionThread() throws InterruptedException {
       Runnable run =  new Runnable() {
            ThreadLocal<String> localThread  = new ThreadLocal<String>(){ };
           InheritableThreadLocal <String> inheritedLocalThread  = new InheritableThreadLocal<String>(){ };
            String withoutThreadLocal = "";
           @Override
            public void run() {
              String uuid  = UUID.randomUUID().toString();
                localThread.set(uuid);
                withoutThreadLocal = uuid;

                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName()+" "+localThread.get());
               System.out.println(Thread.currentThread().getName() + "withoutThreadLocal " +withoutThreadLocal);
               System.out.println(Thread.currentThread().getName() + "withoutThreadLocal " +withoutThreadLocal);

               // Integer.parseInt("qw");
            }
        };
        Thread t = new Thread(run );
        Thread t2 = new Thread(run );
        Thread t3 = new Thread(run );
        Thread t4 = new Thread(run );
        t.setUncaughtExceptionHandler(new Thread.UncaughtExceptionHandler() {
            @Override
            public void uncaughtException(Thread t, Throwable e) {
                System.out.print(t.getName());
            }
        });

        t.start();
        t2.start();
        t3.start();
        t4.start();

        t.join();

    }

        public static void preorityThread() {
        Thread[] threads = new Thread[10];
        Thread.State[] status = new Thread.State[10];

        for(int i = 0; i < 10; i++ ){
            threads[i] = new Thread(new Calculator(i));
            threads[i].setName("Thread name "+i);
            if(i%2 == 0){
                threads[i].setPriority(Thread.MAX_PRIORITY);
            }else{
                threads[i].setPriority(Thread.MIN_PRIORITY);
            }
        }
        for (int i=0; i<10; i++){

            status[i]=threads[i].getState();
        }
        for (int i=0; i<10; i++){
            threads[i].start();
        }
        boolean finish=false;
        while (!finish) {
            for (int i=0; i<10; i++){
                if (threads[i].getState()!=status[i]) {
                    writeThreadInfo( threads[i],status[i]);
                    status[i]=threads[i].getState();
                }
            }
            finish=true;
            for (int i=0; i<10; i++){
                finish=finish &&(threads[i].getState()== Thread.State.TERMINATED);
            }
        }

    }
    private static void writeThreadInfo(  Thread
            thread, Thread.State state) {
        System.out.printf(" Main : Id %d - %s\n",thread.getId(),thread.getName());
        System.out.printf(" Main : Priority: %d\n",thread.getPriority());
        System.out.printf(" Main : Old State: %s\n",state);
        System.out.printf(" Main : New State: %s\n",thread.getState());
        System.out.printf(" Main : ************************************\n");
    }
    public static void makeThread(){
        final MyThread c=new MyThread();
        new Thread(){
            private int a =0;
            public void run(){c.withdraw(15000);}
        }.start();
        new Thread(){
            public void run(){c.deposit(10000);}
        }.start();

    }
}
