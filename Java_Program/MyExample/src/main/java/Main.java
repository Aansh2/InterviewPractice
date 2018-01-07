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

/**
 * Created by nikhil on 11/9/16.
 */

public class Main {

    public static void main(String [] args) {
        LinkedHashSet  set = new LinkedHashSet();
        set.add(null);
        set.add(new Employee("Nikk",1));
        Set syncSet = (Set) Collections.synchronizedSet(set);
        set=null;
        syncSet.add("ni");
        System.out.print("Done");
    }

    private void makeMap(){
        Map map = new HashMap<Employee,String>();
        map.put(new Employee("Nikhil",1),"me");
        map.put(new Employee("Ruby",1),"Nunni");

        map.put(new Employee("Nikhil Soni",1),"again me ");

        map.put(new Employee("Nikhwil",1),"me");
        map.put(new Employee("Rubwy",1),"Nunni");

        map.put(new Employee("Nikhil Soniw",1),"again me ");
        map.put(new Employee("Nikhil Sonidw",1),"again me ");
        map.put(new Employee("Nikhil Sonwiq",1),"again me ");
        map.put(new Employee("Nikhil Sonqwi",1),"again me ");
        map.put(new Employee("Nikhil Soddniw",1),"again me ");
        map.put(new Employee("Nikhil Sofniw",1),"again me ");
        map.put(new Employee("Nikhil Sognwiq",1),"again me ");
        map.put(new Employee("Nikhil Sohnqwi",1),"again me ");
        new  IdentityHashMap<String,String>();
        new Hashtable<String,String>();
        LinkedHashMap linkedHashMap =  new LinkedHashMap<Employee,String>();
        linkedHashMap.put(new Employee("Nikhil",1),"me");
        linkedHashMap.put(new Employee("Ruby",2),"Nunni");

        linkedHashMap.put(new Employee("Nikhil Soni",1),"again me ");


    }

}
