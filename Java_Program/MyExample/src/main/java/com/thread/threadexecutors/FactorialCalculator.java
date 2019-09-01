package com.thread.threadexecutors;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * Created by nikhil on 15/3/18.
 */
public class FactorialCalculator   implements Callable<Integer >  {

    private Integer number;

    public FactorialCalculator(Integer number){
        //super(this);
         this.number=number;
    }

    @Override
    public Integer call() throws Exception {
        int result = 1;
        if ((number==0)||(number==1)) {
            result=1;
        } else {
            for (int i=2; i<=number; i++) {
                result*=i;
                TimeUnit.MILLISECONDS.sleep(2000);
            }
            System.out.printf("%s: %d\n",Thread.currentThread().
                    getName(),result);
        }
        return result;

    }

    public static void main1(String[] args) {
        ThreadPoolExecutor executor=(ThreadPoolExecutor) Executors.
                newFixedThreadPool(2);
        List<Future<Integer>> resultList=new ArrayList<>();
        Random random=new Random();
        for (int i=0; i<10; i++) {
            Integer number = random.nextInt(10);
            FactorialCalculator calculator = new
                    FactorialCalculator(number);
            Future<Integer> result = executor.submit(calculator);
            resultList.add(result);
        }
        do {
            System.out.printf("Main: Number of Completed Tasks: %d\n",executor.getCompletedTaskCount());
            for (int i=0; i<resultList.size(); i++) {
                Future<Integer> result=resultList.get(i);
                System.out.printf("Main: Task %d: %s\n",i,result.
                        isDone());
            }
            try {
                TimeUnit.MILLISECONDS.sleep(50);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        } while (executor.getCompletedTaskCount()<resultList.size());

        System.out.printf("Main: Results\n");
        for (int i=0; i<resultList.size(); i++) {
            Future<Integer> result=resultList.get(i);

            Integer number=null;
            try {
                number=result.get();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }
            System.out.printf("Main: Task %d: %d\n",i,number);
        }
        executor.shutdown();
    }
    public static void main(String[] args) throws Exception {
        ThreadPoolExecutor executor=(ThreadPoolExecutor) Executors.
                newFixedThreadPool(2);
        List<Future<Integer>> resultList=new ArrayList<>();
        List<FactorialCalculator> factorialCalculators=new ArrayList<>();

        Random random=new Random();
        for (int i=0; i<10; i++) {
            Integer number = random.nextInt(10);
            FactorialCalculator calculator = new
                    FactorialCalculator(number);
            factorialCalculators.add(calculator);
        }
        System.out.println("Waiting Started");

        //resultList =  executor.invokeAny(factorialCalculators);
         Integer ints =  executor.invokeAny(factorialCalculators);

        System.out.println("Waiting is completed");


        do {
            System.out.printf("Main: Number of Completed Tasks: %d\n",executor.getCompletedTaskCount());
            for (int i=0; i<resultList.size(); i++) {
                Future<Integer> result=resultList.get(i);
                System.out.printf("Main: Task %d: %s\n",i,result.
                        isDone());
            }
            try {
                TimeUnit.MILLISECONDS.sleep(50);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        } while (executor.getCompletedTaskCount()<resultList.size());

        System.out.printf("Main: Results\n");
        for (int i=0; i<resultList.size(); i++) {
            Future<Integer> result=resultList.get(i);

            Integer number=null;
            try {
                number=result.get();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }
            System.out.printf("Main: Task %d: %d\n",i,number);
        }
        executor.shutdown();
    }

}
