package com.component;

import com.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by nikhil on 7/1/18.
 */
@Component
public class MessagePrinter {

    @Autowired
    private MessageService messageService;

    public void printMessage() {
        System.out.println(this.messageService.getMessage());
    }
}
