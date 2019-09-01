package com.DS;

import com.model.Employee;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * Created by nikhil on 4/4/18.
 */
public class MyAllMap {


    public static void main(String [] args) throws Throwable{
        ConcurrentHashMap c =     new ConcurrentHashMap();
                                  new LinkedBlockingQueue();

       System.out.print(  binomialCoeff(3,5));

    }

    public static void cuncurrentHashMap(){
        ConcurrentHashMap c =     new ConcurrentHashMap();
        c.put(1,"a");
    }

    private static  void makeMapWithCustom(){
        Map map = new HashMap<Employee,String>();
        Employee e = new Employee("Nikhil",1 ) ;
        map.put(e,"1");
        map.put(e,"d2wd");
        System.out.print(map.get(""));
        TreeMap tTreeMap = new TreeMap();
        tTreeMap.put(new Employee("Z",1 ),"");
        tTreeMap.put(new Employee("B",1 ),"");

        tTreeMap.put(new Employee("C",1 ),"");
        tTreeMap.put(new Employee("D",1 ),"");
        tTreeMap.put(new Employee("A",1 ),"");



    }

    /// TomTom

    public static int solution(int[] A) {
        // write your code in Java SE 8
        int sum = 0;
        int maximumPs = Integer.MIN_VALUE;
        int sumPs = 0;
        int maxVal = Integer.MIN_VALUE;
        boolean isPsFound = false;
        boolean containsPos = false;
        for (int i = 0; i < A.length; i++) {
            sum += A[i];
            maxVal = Math.max(maxVal, A[i]);
            if (A[i] >= 0) {
                isPsFound = true;
                containsPos = true;
                sumPs += A[i];
                maximumPs = Math.max(sumPs, maximumPs);

            } else if (A[i] < 0) {
                sumPs = 0;
                isPsFound = false;
            }


        }
        int min = Integer.MAX_VALUE;
        int ans = 0;
        int collectiveSum = 0;

        for (int i = 0; i < A.length; i++) {
            collectiveSum += A[i];
            int def = sum - (collectiveSum);
            if (def < min) {
                min = def;
                ans = collectiveSum;
            }

        }
        if (!containsPos) return maxVal;
        return Math.max(ans, maximumPs);

    }

    static int binomialCoeff(int N, int K)
    {
        int C[][] = new int[N+1][K+1];
        int i, j;

        // Calculate value of Binomial Coefficient in bottom up manner
        for (i = 0; i <= N; i++)
        {
            for (j = 0; j <= min(i, K); j++)
            {
                // Base Cases
                if (j == 0 || j == i)
                    C[i][j] = 1;

                    // Calculate value using previosly stored values
                else
                    C[i][j] = C[i-1][j-1] + C[i-1][j];
            }
        }

        return C[N][K];
    }

    // A utility function to return minimum of two integers
    static int min(int a, int b)
    {
        return (a<b)? a: b;
    }

    static int find(int[] A )
    {
        int max = 0;
        java.util.List<Integer > listConatinCurrentNumbers = new java.util.ArrayList<>();
        for (int i = 0; i < A.length; i++) {
            listConatinCurrentNumbers.clear();
            listConatinCurrentNumbers.add(A[i]);
            for (int j = i; j < A.length; j++) {
                if(!checkNumberIsValid(A[i],A[j],listConatinCurrentNumbers) ){
                    if(max < j - i ){
                        max =j - i;
                    }
                }
            }
        }
        return max-1;
     }
     static boolean checkNumberIsValid(int a , int b ,List<Integer > listConatinCurrentNumbers ){
         if(listConatinCurrentNumbers.size() == 1){
             listConatinCurrentNumbers.add(b);
             return true;
         }
         if(listConatinCurrentNumbers.size() == 2 &&  !listConatinCurrentNumbers.contains(b)){
             return false;
         }else {
             return true;

         }

     }
}
