package com;

import com.component.MessagePrinter;
import com.model.HelloWorld;
import com.service.MessageService;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;

/**
 * Created by nikhil on 7/1/18.
 */
@Configuration
@ComponentScan
public class Application {
    @Bean
    MessageService mockMessageService() {
        return new MessageService() {
            public String getMessage() {
                return "Hello World!";
            }
        };
    }

    public static void main(String[] args) {

      callXmlBeanFactory();
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


    }
    private static void callAnnotationConfigApplicationCx(){
        ApplicationContext cx = new AnnotationConfigApplicationContext(Application.class);
        MessagePrinter mp = cx.getBean(MessagePrinter.class);
        mp.printMessage();
    }

}
