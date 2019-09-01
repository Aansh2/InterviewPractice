package com.soap;

import javax.xml.ws.Endpoint;

/**
 * Created by nikhil on 23/2/18.
 */
public class HelloWorldPublisher {
    public static void main(String[] args) {
        Endpoint.publish("http://localhost:7779/ws/hello", new HelloWSRPCWorldImpl());


    }
}
