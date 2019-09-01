import com.model.Employee;
import com.model.Person;

import java.io.IOException;
import java.lang.ref.WeakReference;
import java.lang.reflect.Constructor;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.IdentityHashMap;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;

import java.util.Map;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * Created by nikhil on 11/9/16.
 */

public class Main {


    static String msg = "hi";

    TreeSet<String> al=new TreeSet<String>(String::compareTo);



    public static void main(String [] args) throws Throwable{
        ConcurrentHashMap c =     new ConcurrentHashMap();
        new LinkedBlockingQueue();
       // String abbb = "Hi"+args[0];
       /* Main m = new Main ();
        Class c=args.getClass();
        String name=c.getName();

        System.out.println(name);
        m.doInitializeObject();*/
        makeMapWithCustom();
        compareStringObjects();

    }

    private static void doInitializeObject() throws Exception{

         String a = "";
        new String("knkln");
        String t = "Java";
        for (int i=0; i<10000; i++){
            t = t + "Tpoint";
        }
        Employee em = new Employee("Nikhil",2 );

      // if not static  Employee.EmployeeInner ei =  em.new EmployeeInner();
        Employee.EmployeeInner i = new Employee.EmployeeInner();
        new Employee.EmployeeInner();
        em.p(58);
        em.p(new Integer(66));
        em.setAge(66);
        em.setAge(new Integer(50));

        em.setAge( 20,new Integer(66));
        em.setAge(20,66);

        em.setPearsonName(20,20);
        Person em3 = em;
        em3.setPearsonName(20,20);
        //  em.setAge( new Integer(66),new Integer(66));


        em =null;
        System.gc();
        Constructor c =  Class.forName(Employee.class.getName()).getConstructor(String.class,int.class);
        Employee em2= (Employee)  c.newInstance("R",5);
        System.out.print(em2);
        WeakReference ref = new WeakReference<Object>(em2);
        Employee emp3 = (Employee) ref.get();
        Thread th = new Thread(new Employee("R",8));
        th.setDaemon(true);
        th.start();

        //th.start();
       // th.wait();
        System.out.println("th.start();");
        msg.wait();
       // th.join();

    }
    private static  void makeMap(){
        Map map = new HashMap<Employee,String>();
        Map<Employee,String> tree = new TreeMap();

        map.put(new Employee("Nikhil",1 ),"me");
        map.put(new Employee("vd",1 ),"me");
        map.put(new Employee("Nikvdhil",1 ),"me");
        map.put(new Employee("vv",1 ),"me");
        map.put(new Employee("vv",1 ),"me");
        map.put(new Employee("Nikbhil",1 ),"me");
        map.put(new Employee("Nikmhil",1 ),"me");
        map.put(new Employee("Nikhnil",1 ),"me");
        map.put(new Employee("Nilkhil",1 ),"me");
        map.put(new Employee("Nikh,il",1 ),"me");
        map.put(new Employee("Nikhil",1 ),"me");
        map.put(new Employee("Nikuhil",1 ),"me");
        map.put(new Employee("Nikuhil",1 ),"me");
        map.put(new Employee("Nikwwhil",1 ),"me");
        new  IdentityHashMap<String,String>();
        new Hashtable<String,String>();
        LinkedHashMap linkedHashMap =  new LinkedHashMap<Employee,String>();
        linkedHashMap.put(new Employee("Nikhil",1 ),"me");


        linkedHashMap.put(new Employee("Nikhil Soni",1 ),"again me ");
        new TreeMap().put(new Employee("Nikhil Soni",1 ),"");

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
    public static void StringExample() throws InterruptedException {
        String s1 = "Cat";
        String s2 = "Cat";
        String s3 = new String("Cat");

        System.out.println("s1 == s2 :"+(s1==s2));
        System.out.println("s1 == s3 :"+(s1==s3));
        Thread.currentThread().sleep(100000000);
    }

    private static final int NTHREDS = 10;

    public static void executorServicee(String[] args) throws InterruptedException {
        ExecutorService executor = Executors.newFixedThreadPool(NTHREDS);
        for (int i = 0; i < 10; i++) {
            Runnable worker = new Employee("jikj",i);
            executor.execute(worker);
        }
        // This will make the executor accept no new threads
        // and finish all existing threads in the queue
        executor.shutdown();
        // Wait until all threads are finish
        executor.awaitTermination(10,null);
        System.out.println("Finished all threads");
    }




  static    void compareStringObjects(){
        String  a = "a";
        String b = "a";
        String c = new String("a");

        System.out.print("a " + a +"b " +b+"c "+c);


    }


    class A{



        final private void ab() throws NullPointerException{

                    throw  new NullPointerException();

        }

             public   void main(String args[] ) throws Exception {
                 Scanner scanner = new Scanner(System.in);
                 int size = scanner.nextInt();

                 for (int i = 0; i < size; i++) {
                     int numberOfDays = scanner.nextInt();
                     int[] prices = new int[numberOfDays];
                     for (int j = 0; j < numberOfDays; j++) {
                         prices[j] = scanner.nextInt();
                     }
                     System.out.println(getMaximumProfit(prices));
                 }

             }
            public   long getMaximumProfit(int[] prices) {
                long profit = 0l;
                int maxTill = 0;
                for (int i = prices.length - 1; i > -1 ; i--) {
                    if (prices[i] >= maxTill) {
                        maxTill = prices[i];
                    }
                    profit += maxTill - prices[i];
                }
                return profit;
            }
        }

    }







