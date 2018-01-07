package com.model;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

/**
 * Created by nikhil on 7/1/18.
 */
public class HelloWorld implements BeanPostProcessor {

    private String message;
    private HelloIndia helloIndia;
    private List addressList;
    private Set addressSet;
    private Map addressMap;
    private Properties addressProp;

    /*public HelloWorld(HelloIndia helloIndia, String name , int number) {
        this.helloIndia = helloIndia;
    }*/
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
        return null;
    }

    @Override
    public Object postProcessAfterInitialization(Object o, String s) throws BeansException {
        System.out.println("In postProcess After Initialization...");

        return null;
    }
}
