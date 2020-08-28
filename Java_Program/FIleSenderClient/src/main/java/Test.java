import java.time.Instant;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

public class Test {

    public static class A {

        int a;
        Date date = null;
        AtomicInteger count = new AtomicInteger();

        public void setA(int a) {

            this.a = a;
            countAndSet();
        }

        private void countAndSet() {
            if (date == null) {
                date = new Date();

            } else {
                Instant now = Instant.now(); //  600
                int min = new Date().getMinutes();
                if ((min < date.getMinutes())) {

                } else {
                    count.incrementAndGet();
                }
            }
        }

    }

    public static void main(String[] args) {
        A a = new A();
        a.setA(1);
        try {
            Thread.sleep(100);
            a.setA(2);

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    // cass a method

    // list user , marks sort by marks
    private void sortIt() {
        List<A> aList = new ArrayList<>();
        aList.stream().sorted((a, t1) -> {
            if (a.a > t1.a) {
                return 0;
            } else {
                return 1;
            }
        }).collect(Collectors.toList());
    }

    // list user , marks sort by marks
    private void getName(List<A> aList) {
         aList.stream().map(a->a.a).collect(Collectors.toList());
    }


}
