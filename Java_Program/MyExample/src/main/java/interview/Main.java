package interview;

 import sun.reflect.generics.tree.Tree;

import java.util.Stack;

/**
 * Created by nikhil on 22/2/18.
 */
public class Main {

    public static final String FIZZ = "Fizz";
    public static final String BUZZ = "Buzz";
    public static final String WOOF = "Woof";

    public static void main(String[] a) {
       // solution(24);
        Runtime.getRuntime().gc();
        System.gc();
     //   System.out.println(getIndexNumber2("(())))"));
        //d("({()}))");
        maximumCupcakes(null);
    }


    public static void solution(int N) {
        // write your code in Java SE 8
        for (int i = 1; i <= N; i++) {
          System.out.println(getWordByNuber(i));
        }
    }

    /**
     * getWordByNuber
     * @param i
     * @return String which is replaced Word otherwise number string
     */
    public static String getWordByNuber(int i) {
        StringBuilder replacedWord = new StringBuilder();

         if (i % 3 == 0) {
             replacedWord.append(FIZZ);
        }

         if (i % 5 == 0) {
             replacedWord.append(BUZZ);
        }

         if (i % 7 == 0) {
             replacedWord.append(WOOF);
        }

         if (replacedWord.length() == 0) {
             replacedWord.append(i);
        }
        return replacedWord.toString();
    }



    ////// logc on String "()(()))"

    // Method to find an equal index
    static int getIndexNumber(String str)
    {
        int len = str.length();
        int open[] = new int[len+1];
        int close[] = new int[len+1];
        int index = -1;

        open[0] = 0;
        close[len] = 0;
        if (str.charAt(0)=='(') {
            open[1] = 1;
        }

        if (str.charAt(len-1) == ')') {
            close[len - 1] = 1;
        }
        for (int i = 1; i < len; i++) {
            if ( str.charAt(i) == '(' ) {
                open[i + 1] = open[i] + 1;
            }
            else {
                open[i + 1] = open[i];
            }
        }

        for (int i = len-2; i >= 0; i--)
        {
            if ( str.charAt(i) == ')' ) {
                close[i] = close[i + 1] + 1;
            }
            else {
                close[i] = close[i + 1];
            }
        }


        if (open[len] == 0)
            return len;
        if (close[0] == 0)
            return 0;


        for (int i=0; i<=len; i++) {
            if (open[i] == close[i]) {
                index = i;
            }
        }
        return index;
    }

    static int getIndexNumber2(String str) {
        int len = str.length();
        int open[] = new int[len+1];
        int close[] = new int[len+1];
        int index = -1;

        open[0] = 0;
        close[len] = 0;

        for (int i = 0; i < len; i++) {
            if ( str.charAt(i) == '(' ) {
                open[i + 1] = open[i] + 1;
            }
            else {
                open[i + 1] = open[i];
            }
        }

        for (int i = len-1; i >= 0; i--)
        {
            if ( str.charAt(i) == ')' ) {
                close[i] = close[i + 1] + 1;
            }
            else {
                close[i] = close[i + 1];
            }
        }


        if (open[len] == 0)
            return len;
        if (close[0] == 0)
            return 0;


        for (int i=0; i<=len; i++) {
            if (open[i] == close[i]) {
                index = i;
            }
        }
        return index;
    }

    // Select dep.dept_id,COUNT(*),SUM(Salary) From employee emp Inner Join department dep ON emp.dept_id=dep.dept_id
   // Group BY dep.dept_id ORDER BY dep.dept_id ASC;

    /*


     Select dep.dept_id,COUNT(*),SUM(Salary) From employee emp Inner Join department dep ON emp.dept_id=dep.dept_id
Group BY dep.dept_id ORDER BY dep.dept_id ASC;

 */
    public int solution(Tree T) {
        // write your code in Java SE 8
        return findHight(T)-1;
    }
    public int findHight(Tree root) {
        if (root == null) {
            return 0;
        }

        int lh = 0 ;//findHight(root.l);
        int rh = 0 ;//findHight(root.r);
        if (rh > lh) {
            return 1+ rh;
        } else {
            return  1+ lh;
        }
    }

    static int getIndexNumber3(String str) {
        char[] array = str.toCharArray();
        int count = 0;
        boolean isEven= false;
       for(int i = 0 ; i < array.length ; i++){
           if(array[i] == array[array.length - i - 1]){
               continue;
           }else{
               count++;
           }
       }



        System.out.print(count);
        return count;
    }
//iNox string balance






public static void d(String testString){
    Stack<Character> stringStack = new Stack<>();
    char[] chars = testString.toCharArray();

        for (int i = 0; i < chars.length; i++) {
        switch (chars[i]) {
            case '(':
            case '[':
            case '{':
                stringStack.push(chars[i]);
                break;
            case ')':
                if (isMatchingClose(stringStack, '(')) {
                    System.out.println("Not balanced: no matching (");
                    return;
                }
                break;
            case ']':
                if (isMatchingClose(stringStack, '[')) {
                    System.out.println("Not balanced: no matching [");
                    return;
                }
                break;
            case '}':
                if (isMatchingClose(stringStack, '{')) {
                    System.out.println("Not balanced: no matching {");
                    return;
                }
                break;
        }
    }
        if (stringStack.isEmpty()) {
        System.out.println(testString + " is balanced String.");
    } else {
        System.out.println(testString + " is NOT balanced String.");
    }
}

    private static boolean isMatchingClose(Stack<Character> stringStack, char openingBracket) {
        return stringStack.isEmpty() || !stringStack.pop().equals(openingBracket);
    }


    // Dam saparated and store with cup  wih rapper

    static void maximumCupcakes(String[] tripss) {
        String[] trips = new String[3];
        trips[0] = "10 2 5";  // 6
        trips[1] = "12 4 4";  // 3
        trips[2] = "6 2 2";   // 3 + 3 + 1


        int remaining = 0;
        for (int i = 0; i < trips.length; i++) {
            String[] input = trips[i].split(" ");

            int dollor = Integer.parseInt(input[0]);
            int cost = Integer.parseInt(input[1]);
            int neededWrapper = Integer.parseInt(input[2]);

            int quantity = dollor / cost;
            int totalWrapper = quantity + remaining;
            int free = 0;
            int remainingBy = 0;


            while ( totalWrapper >= neededWrapper) {
                free = totalWrapper/neededWrapper;
                quantity = quantity+free;
                totalWrapper = free+ totalWrapper%neededWrapper;

             }
           // remaining = totalWrapper;
            System.out.println(quantity);

        }

    }
}


