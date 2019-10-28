package com.DS;



 import java.util.*;
 import java.util.stream.Stream;

public class AllCollection {

  public static void main(String[] args) throws Throwable {
    // initializeCollectionClasses();
    myCollectionStudy();
  }

  public static void setCollection() {

    Set hashset = new HashSet<String>();

    hashset.add("nikhil");
    hashset.add("ruby");

    System.out.println(hashset);
  }

  public static void initializeCollectionClasses() {
    List<String> list1 = new ArrayList();
    List<String> list2 = new LinkedList();
    List<String> list3 = new Vector();
    List<String> list4 = new Stack();
    Queue<String> q1 = new PriorityQueue();
    Queue<String> q2 = new ArrayDeque();

    Set hashset = new HashSet<String>();
    SortedSet<String> weekDays =
        new TreeSet<>(String.CASE_INSENSITIVE_ORDER); // String.CASE_INSENSITIVE_ORDER;
    // Comparator.reverseOrder()
    weekDays.add("Ps1");
    Set treeSet = new TreeSet();

    new LinkedList();
    new TreeSet();
    List arrayList = new ArrayList<>();
    arrayList.add("zNikhil Soni");
    arrayList.add("Ruby Soni");
    arrayList.add("ABC Soni");
     arrayList.addAll(weekDays);
    //  treeSet.add((String)null);
    // treeSet.add(null);

    //  arrayList.stream().sorted().forEach(e-> System.out.println(e.toString()));
    Stream stream = arrayList.stream();
    stream.count();
    Set synchedSet = Collections.synchronizedSet(new HashSet<>());
    arrayList.iterator().forEachRemaining(e -> System.out.println(e.toString()));
    System.out.println(hashset);

    Set<String> linkedHashSet = new LinkedHashSet<>();
    linkedHashSet.add("element 1");
    linkedHashSet.add("element 2");
    linkedHashSet.add("element 3");
    linkedHashSet.add("element 4");
    linkedHashSet.forEach(
        e -> {
          System.out.println(e);
          // linkedHashSet.remove("element 4");
        });

    Deque deque = new ArrayDeque();
    deque.add("nikhi");
    deque.add("ruby");
    deque.addLast("mohan");

    Stack stack = new Stack();
    stack.add("nikhil");
    stack.add("soni");
  }
  // Legends :    P- In-progress C - completed
  public static void myCollectionStudy() {
    // C Array List
    ArrayList a = new ArrayList<>();
    a.add("b");
    a.add("a");
    a.add("z");
    a.add("g");
    a.sort(String.CASE_INSENSITIVE_ORDER);
    a.sort(
        new Comparator() {
          @Override
          public int compare(Object o1, Object o2) {

            return ((String) o1).compareTo((String) (o2));
          }
        });
    a.stream().forEach(System.out::println);

    // C LinkedList
    /*
     * Java LinkedList class can be used as a list, stack or queue.
     *
     *
     */
    LinkedList<String> linkedList = new LinkedList();
    linkedList.add("a");

    // C Java HashSet
    /*
     * HashSet stores the elements by using a mechanism called hashing.
     * HashSet allows null value
     */
    HashSet hashSet = new HashSet<>();
    hashSet.add("b");

    // C - Java LinkedHashSet class
    /*
     *Java LinkedHashSet class maintains insertion order.
     * 1.  is just like HashMap with an additional
     *  feature of maintaining an order of elements inserted into it.
     * 2. In the LinkedHashMap implementation, the LinkedHashMap.Entry class
     * extends the HashMap.Entry class, by adding before and after fields.
     *
     *
     */
    LinkedHashSet linkedHashSet = new LinkedHashSet<>();
    linkedHashSet.add("a");

    // C Java TreeSet class
    /*
     * It uses TreeMap
     *
     */
    new TreeSet<String>();

    // C PriorityQueue or Queue
    /*
    * LinkedList is Queue, so it can be used as Queue
    * PriorityQueue short by Comparator which can hold Duplicate
    * Applications of Priority Queue:
      Applications where priority is 1) CPU Scheduling
      2) Graph algorithms like Dijkstra’s shortest path algorithm, Prim’s Minimum Spanning Tree, etc
      3) All queue applications where priority is involved
    *
    */
    PriorityQueue priorityQueue = new PriorityQueue<String>();

    /*
    * Dequeue implementaion is  ArrayDeque
    * Application of Undo function
    * */
    ArrayDeque arrayDeque  = new ArrayDeque<>();
    arrayDeque.add("a");
     /*
    *  Stack internally uses Vector
    *
    */
    List stk = new Stack();

  }
}
