import java.time.Instant;
import java.util.Date;
import java.util.Timer;
import java.util.concurrent.atomic.AtomicInteger;

public class Temp {

    public  static class A {
        int a ;
        Date date  = null ;
        AtomicInteger count = new AtomicInteger();

        public void setA(int a){

            this.a = a ;
            countAndSet();
        }

        private void  countAndSet(){
            if(date == null ){
                date =   new Date();

            }else {
                Instant now = Instant.now(); //  600
                int min = new Date().getMinutes();
                if( (min < date.getMinutes() )  ){

                }
            }
        }

    }

    public static void main(String[] args) {
      A a =   new A();
      a.setA(1);
        try {
            Thread.sleep(100);
            a.setA(2);

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

  // cass a method



}
