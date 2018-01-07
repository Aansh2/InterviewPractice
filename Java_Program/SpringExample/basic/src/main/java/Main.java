
import com.model.HelloWorld;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

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
@SpringBootApplication
public class Main {

    public static void main(String [] args) {
        ApplicationContext ctx = SpringApplication.run(Main.class, args);
        HelloWorld helloWorld = (HelloWorld) ctx.getBean("helloWorld");
        helloWorld.sayHello();


    }



}
