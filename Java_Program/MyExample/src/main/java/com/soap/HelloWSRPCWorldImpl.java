package com.soap;

import com.srvc.HelloWSRPCWorld;

import javax.jws.WebService;

/**
 * Created by nikhil on 23/2/18.
 */
@WebService(endpointInterface = "com.srvc.HelloWSRPCWorld")
public class HelloWSRPCWorldImpl implements HelloWSRPCWorld {
    @Override
    public String getHelloWorldAsString(String name) {
        return null;
    }
}
