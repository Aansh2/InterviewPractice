import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.CompletionService;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorCompletionService;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.concurrent.Callable;
import java.util.stream.Collectors;

public class TempClass {

    public static void main(String[] args) throws Exception {
       //save();
        getDuplicate();
        try {

        }catch(NullPointerException e ){
            System.out.println("NullPointerException");
        }
        System.out.println("ahead");

        ExecutorService newFixedThreadPool =  Executors.newFixedThreadPool(1);
       ExecutorService newSingleThreadExecutor =  Executors.newSingleThreadExecutor();
       ExecutorService newCachedThreadPool =  Executors.newCachedThreadPool();
       ScheduledExecutorService newScheduledThreadPool =  Executors.newScheduledThreadPool(2);
       newScheduledThreadPool.scheduleWithFixedDelay(()-> System.out.println("hi"), 0, 1 , TimeUnit.SECONDS);
       Future<String> f = (Future<String>) newSingleThreadExecutor.submit(()-> {
           System.out.println("Callable thread");
        return "ok;";
       }
       );
       String x =  f.get();
       System.out.println(x);

       ExecutorCompletionService executorCompletionService = new ExecutorCompletionService<String>(newSingleThreadExecutor);
       executorCompletionService.poll();


       // Internal class
        int corePoolSize =
                2;
        int maximumPoolSize =  2;
        long keepAliveTime = 0L;
        new ThreadPoolExecutor(corePoolSize, maximumPoolSize,
                keepAliveTime, TimeUnit.MILLISECONDS,
                new LinkedBlockingQueue<Runnable>());

    }

    public static void save() throws Exception {


    }







    static String a = "Semeter";
    // s e
    // m
    // e t e r
    public static void  getDuplicate(){
        "ab".indexOf(0);
        List<Integer> list = new ArrayList<>();
     /* Integer f =  list.stream().filter((e)->{
           if( e % 3 == 0 ){
                return true;
            } else {
               return false;
           }
        }).collect( Collectors.summingInt(Integer::intValue);*/
    }


    /*Stron ,

    1 topic mess
            two consumers defer
                consume.

                        SOLID  L =

                        final

    threa threa

                                List<> */




























    }

