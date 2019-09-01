package com;

import com.component.ExampleAspect;
import com.component.MessagePrinter;
import com.model.HelloIndia;
import com.model.HelloWorld;
import com.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.EnableLoadTimeWeaving;
import org.springframework.context.event.ContextClosedEvent;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.ContextStartedEvent;
import org.springframework.context.event.ContextStoppedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by nikhil on 7/1/18.
 */
@Configuration("config")
@ComponentScan(basePackageClasses = {com.component.MessagePrinter.class, HelloIndia.class, ExampleAspect.class})
@EnableAspectJAutoProxy(proxyTargetClass=true)
@EnableLoadTimeWeaving

public class Application {
    @Autowired
    public List<HelloIndia> helloIndiaList;
    @Autowired
    public HelloIndia  helloIndia;


    /*@Autowired
    @Qualifier("emails")
    public List<String> emials;*/

    @Resource
    private ApplicationContext context;


    @Bean
    MessageService mockMessageService() {
        return new MessageService() {
            public String getMessage() {
                return "Hello World!";
            }
        };
    }

    public static void main(String[] args) {
        callAnnotationConfigApplicationContext();
        // callAnnotationConfigApplicationContext();
     // callXmlBeanFactory();
     //  callClassPathXmlApplicationContext();
    }

    private static void callXmlBeanFactory(){
        XmlBeanFactory cx =  new XmlBeanFactory(new ClassPathResource( "bean.xml"));

        HelloWorld hw = (HelloWorld) cx.getBean("helloWorld");
        hw.sayHelloFromWorld();
        hw.sayHelloFromIndia();
        hw.setMessage("Update Hi World.");
        cx.removeBeanDefinition("helloWorld");

    }

    private static void callClassPathXmlApplicationContext(){
        ApplicationContext context =  new ClassPathXmlApplicationContext("bean.xml");
        HelloWorld hw = (HelloWorld) context.getBean("helloWorld");
         hw.sayHelloFromWorld();
        hw.toString();

    }
    private static void callAnnotationConfigApplicationCx(){
        AnnotationConfigApplicationContext cx = new AnnotationConfigApplicationContext(Application.class);
        cx.register(Application.class);

        HelloIndia helloIndia = (HelloIndia) cx.getBean(HelloIndia.class);
        MessagePrinter mp = cx.getBean(MessagePrinter.class);
        mp.printMessage();
    }

    private static void callAnnotationConfigApplicationContext(){
        AnnotationConfigApplicationContext cx = new AnnotationConfigApplicationContext(Application.class);
         cx.register(Application.class);

      // cx.refresh();

        HelloIndia helloIndia = (HelloIndia) cx.getBean(HelloIndia.class);
        Application application = (Application) cx.getBean(Application.class);
        HelloWorld  helloWorld = (HelloWorld) cx.getBean(HelloWorld.class);
        cx.publishEvent(new AListenerBean( ));
        cx.publishEvent(new AListenerBean( ));
        cx.stop();
        cx.start();
      System.out.print(helloWorld.getMessage());
        helloWorld.setMessage("[ Updated ]"+ "Hello India");

    }





    private static class AListenerBean implements ApplicationListener<ContextStoppedEvent> {

        @EventListener
        public void handleContextRefreshed (ContextRefreshedEvent event) {
            System.out.print("context refreshed event fired: ");
            System.out.println(event);
        }

        @EventListener
        public void handleContextStarted (ContextStartedEvent event) {
            System.out.print("context started event fired: ");
            System.out.println(event);
        }

        @EventListener
        public void handleContextStopped (ContextStoppedEvent event) {
            System.out.print("context stopped event fired: ");
            System.out.println(event);
        }

        @EventListener
        public void handleContextClosed (ContextClosedEvent event) {
            System.out.print("context  closed event fired: ");
            System.out.println(event);
        }

        @Override
        public void onApplicationEvent(ContextStoppedEvent contextStoppedEvent) {
            System.out.print("context  closed event fired: ");
            System.out.println(contextStoppedEvent);
        }
    }
}
