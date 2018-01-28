import com.DS.Stack;
import com.model.Employee;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.IdentityHashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.*;
import java.util.LinkedList;

/**
 * Created by nikhil on 11/9/16.
 */

public class Main {

    public static void main(String [] args) {
        makeMap();
    }

    private static  void makeMap(){
        Map map = new HashMap<Employee,String>();
        map.put(new Employee("Nikhil",1),"me");
        map.put(new Employee("vd",1),"me");
        map.put(new Employee("Nikvdhil",1),"me");
        map.put(new Employee("vv",1),"me");
        map.put(new Employee("vv",1),"me");
        map.put(new Employee("Nikbhil",1),"me");
        map.put(new Employee("Nikmhil",1),"me");
        map.put(new Employee("Nikhnil",1),"me");
        map.put(new Employee("Nilkhil",1),"me");
        map.put(new Employee("Nikh,il",1),"me");
        map.put(new Employee("Nikhil",1),"me");
        map.put(new Employee("Nikuhil",1),"me");
        map.put(new Employee("Nikuhil",1),"me");
        map.put(new Employee("Nikwwhil",1),"me");
        new  IdentityHashMap<String,String>();
        new Hashtable<String,String>();
        LinkedHashMap linkedHashMap =  new LinkedHashMap<Employee,String>();
        linkedHashMap.put(new Employee("Nikhil",1),"me");


        linkedHashMap.put(new Employee("Nikhil Soni",1),"again me ");


    }

}
