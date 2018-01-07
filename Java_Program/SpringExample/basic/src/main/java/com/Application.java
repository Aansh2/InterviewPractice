package com;

import com.component.MessagePrinter;
import com.service.MessageService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

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
        ApplicationContext cx = new AnnotationConfigApplicationContext(Application.class);
        MessagePrinter mp = cx.getBean(MessagePrinter.class);
        mp.printMessage();
    }
}
