package com.srvc;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;

/**
 * Created by nikhil on 23/2/18.
 */
@WebService(name = "HelloWorld",   targetNamespace = "http://ws.mkyong.com/")
@SOAPBinding(style =  SOAPBinding.Style.RPC)
public interface HelloWSRPCWorld {
    @WebMethod
    String getHelloWorldAsString(String name);
}
