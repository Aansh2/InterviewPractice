package com.DS;

import com.model.Employee;
import com.model.PersonMap;

import java.io.FileWriter;
import java.io.IOException;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

/** Created by nikhil on 4/4/18. */
public class MyAllMap {

  public static void main(String[] args) throws Throwable {
    // ConcurrentHashMap c = new ConcurrentHashMap();
    // new LinkedBlockingQueue();

    // System.out.print(binomialCoeff(3, 5));
    AllMap();
  }

  public static void cuncurrentHashMap() {
    ConcurrentHashMap c = new ConcurrentHashMap();
    c.put(1, "a");
  }

  private static void makeMapWithCustom() {
    Map map = new HashMap<Employee, String>();
    Employee e = new Employee("Nikhil", 1);
    map.put(e, "1");
    map.put(e, "d2wd");
    System.out.print(map.get(""));
    TreeMap tTreeMap = new TreeMap();
    tTreeMap.put(new Employee("Z", 1), "");
    tTreeMap.put(new Employee("B", 1), "");

    tTreeMap.put(new Employee("C", 1), "");
    tTreeMap.put(new Employee("D", 1), "");
    tTreeMap.put(new Employee("A", 1), "");
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

  static int binomialCoeff(int N, int K) {
    int C[][] = new int[N + 1][K + 1];
    int i, j;

    // Calculate value of Binomial Coefficient in bottom up manner
    for (i = 0; i <= N; i++) {
      for (j = 0; j <= min(i, K); j++) {
        // Base Cases
        if (j == 0 || j == i) C[i][j] = 1;

        // Calculate value using previosly stored values
        else C[i][j] = C[i - 1][j - 1] + C[i - 1][j];
      }
    }

    return C[N][K];
  }

  // A utility function to return minimum of two integers
  static int min(int a, int b) {
    return (a < b) ? a : b;
  }

  static int find(int[] A) {
    int max = 0;
    java.util.List<Integer> listConatinCurrentNumbers = new java.util.ArrayList<>();
    for (int i = 0; i < A.length; i++) {
      listConatinCurrentNumbers.clear();
      listConatinCurrentNumbers.add(A[i]);
      for (int j = i; j < A.length; j++) {
        if (!checkNumberIsValid(A[i], A[j], listConatinCurrentNumbers)) {
          if (max < j - i) {
            max = j - i;
          }
        }
      }
    }
    return max - 1;
  }

  static boolean checkNumberIsValid(int a, int b, List<Integer> listConatinCurrentNumbers) {
    if (listConatinCurrentNumbers.size() == 1) {
      listConatinCurrentNumbers.add(b);
      return true;
    }
    if (listConatinCurrentNumbers.size() == 2 && !listConatinCurrentNumbers.contains(b)) {
      return false;
    } else {
      return true;
    }
  }

  public static void AllMap() throws IOException {
    /* C
     * HashMap
     * Does not maintain any order
     * In Java 8, HashMap replaces linked list with a binary tree when the number of elements
     *  in a bucket reaches certain threshold
     *
     */

    HashMap hashMap = new HashMap<PersonMap, String>();

    PersonMap p1 = new PersonMap(1, "ABC");
    PersonMap p2 = new PersonMap(1, "DEF");
    PersonMap p3 = new PersonMap(1, "XYZ");
    PersonMap p4 = new PersonMap(1, "PQR");
    PersonMap p5 = new PersonMap(1, "PQR");
    PersonMap p6 = new PersonMap(1, "PQR6");

    PersonMap p7 = new PersonMap(1, "PQR7");

    PersonMap p8 = new PersonMap(1, "PQR8");
    PersonMap p9 = new PersonMap(1, "PQR9");

    System.out.println("Adding Entries ....");
    hashMap.put(p1, "ONE");
    hashMap.put(p2, "TWO");
    hashMap.put(p3, "THREE");
    hashMap.put(p4, "FOUR");
    hashMap.put(p5, "FIVE");
    hashMap.put(p6, "SIX");
    hashMap.put(p7, "SEVEN");
    hashMap.put(p8, "EIGHG");
    hashMap.put(p9, "NINE");

    Collections.synchronizedMap(hashMap);
    /*
     *  C
     * LinkedHashMap It maintains insertion order.
     * Java LinkedHashMap maintains insertion order.
     */

    new LinkedHashMap<>().put("", "");

    /*
     * C - Java TreeMap class
     *
     *TreeMap is a Red-Black tree based NavigableMap implementation.In other words,
     * it sorts the TreeMap object keys using Red-Black tree algorithm.
     * #The great thing about it is that you can find some objects using different filters and conditions.
     *
     */
     TreeMap treemap = new TreeMap<String, String>(String.CASE_INSENSITIVE_ORDER);
    treemap = new TreeMap<String, String>(Comparator.reverseOrder());
    treemap.put("A", "value");
    treemap.get("");
    SortedMap m = Collections.synchronizedSortedMap(new TreeMap());


    /*
    * P - Property
    * The Properties class represents a persistent set of properties.
    * The Properties can be saved to a stream or loaded from a stream.
    * Each key and its corresponding value in the property list is a string.
    *
    * Because Properties inherits from Hashtable, the put and putAll methods can be applied to a Properties object.
    * Their use is strongly discouraged as they allow the caller to insert
    * entries whose keys or values are not Strings. The setProperty method should be used instead.
    */
    Properties properties = new Properties();
    properties.store( new FileWriter("data/props.properties"), "These are properties");
    //properties.setProperty(new Integer(1), new String(""));

    /*
    * C Collections
    *
    */

    Collections.max(new ArrayList<String>(Arrays.asList("E","A","Z")));
  }
}
