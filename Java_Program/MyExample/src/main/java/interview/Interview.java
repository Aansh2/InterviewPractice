package interview;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Interview {
 //  static String a = "110101000000001";
    static String a = "1100000";

    // 0101 0

    // "0101"   111100000
    // length 4 ; 2 pairs
    //  sort

    public static void main(String[] args) {
       // doSomeWork();

       List<Character> list = new ArrayList<>();
        a.toCharArray();
        for (int i = 0; i < a.split("").length; i++) {
                list.add( a.charAt(i));
        }
        Collections.sort(list);

        int lenght = list.size() % 2 == 0 ? list.size() /2  : (list.size() /2 )+1;

        for (int i = 0; i < lenght ; i++) {
            char charAtI= list.get(i);
            char charAtLast= list.get(list.size() - 1 - i);

            if(charAtI != charAtLast ) {
                System.out.print(charAtI);
                System.out.print(charAtLast);
                // till
            } else {
                System.out.print(charAtI);

            }

        }

    }

    static void doSomeWork() throws ExecutionException, InterruptedException {
     ExecutorService executorService =  Executors.newFixedThreadPool(1);
     Future<String> future =  executorService.submit(() -> {
           System.out.println(Thread.currentThread().getName());
           return "";
        });
        future.get();
     }
     //

    // Array list as  source
    // 1 reading // random
    // 2 adding //








 }
