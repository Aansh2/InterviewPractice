package com.soap;

import com.srvc.HelloWSRPCWorld;

import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import java.net.URL;

/**
 * Created by nikhil on 23/2/18.
 */
public class HelloWorldWSRPCClient {
    public static void main(String[] args) throws Exception {
        URL url = new URL("http://localhost:7779/ws/hello?wsdl");

        //1st argument service URI, refer to wsdl document above
        //2nd argument is service name, refer to wsdl document above
        QName qname = new QName("http://ws.mkyong.com/", "HelloWSRPCWorldImplService");
        Service service = Service.create(url, qname);
        HelloWSRPCWorld hello = service.getPort(HelloWSRPCWorld.class);
        System.out.println(hello.getHelloWorldAsString("javatpoint rpc"));
    }
}
