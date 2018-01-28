package com.model;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

/**
 * Created by nikhil on 7/1/18.
 */
@Component
public class HelloWorld implements BeanPostProcessor {

    private String message;
    @Autowired(required = true)
    @Qualifier( "helloIndia")
    private HelloIndia helloIndia;
    private List addressList;
    private Set addressSet;
    private Map addressMap;
    private Properties addressProp;

    private String url ;


    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    /*public HelloWorld(HelloIndia helloIndia, String name , int number) {
                this.helloIndia = helloIndia;
            }*/
    public HelloWorld(  ) {

    }
    public HelloWorld( String name , int number) {

    }

    public HelloIndia getHelloIndia() {
        return helloIndia;
    }
    public void setHelloIndia(HelloIndia helloIndia) {
        this.helloIndia = helloIndia;
    }

    public List getAddressList() {
        return addressList;
    }

    public void setAddressList(List addressList) {
        this.addressList = addressList;
    }

    public Set getAddressSet() {
        return addressSet;
    }

    public void setAddressSet(Set addressSet) {
        this.addressSet = addressSet;
    }

    public Map getAddressMap() {
        return addressMap;
    }

    public void setAddressMap(Map addressMap) {
        this.addressMap = addressMap;
    }

    public Properties getAddressProp() {
        return addressProp;
    }

    public void setAddressProp(Properties addressProp) {
        this.addressProp = addressProp;
    }

    public void sayHelloFromWorld(){
        System.out.println(message);
    }

    public void sayHelloFromIndia(){
        System.out.println(helloIndia.getMessage());
    }

    public String getMessage() {
        System.out.println("getMessage is called...");
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    private void init(){
        System.out.println("In init method...");
    }
    private void destroy(){
        System.out.println("Destroyed...");
    }

    @Override
    public Object postProcessBeforeInitialization(Object o, String s) throws BeansException {
        System.out.println("In postProcess Before Initialization...");
        return o;
    }

    @Override
    public Object postProcessAfterInitialization(Object o, String s) throws BeansException {
        System.out.println("In postProcess After Initialization...");

        return o;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("HelloWorld{");
        sb.append("message='").append(message).append('\'');
        sb.append(", helloIndia=").append(helloIndia);
        sb.append(", addressList=").append(addressList);
        sb.append(", addressSet=").append(addressSet);
        sb.append(", addressMap=").append(addressMap);
        sb.append(", addressProp=").append(addressProp);
        sb.append(", url='").append(url).append('\'');
        sb.append('}');
        System.out.println(sb.toString());
        return sb.toString();
    }
}
