package com.websystique.springboot.configuration;

/**
 * Created by nikhil on 27/1/18.
 */

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;


public class MyWebInitializer extends
        AbstractAnnotationConfigDispatcherServletInitializer {

    @Override
    protected Class<?>[] getRootConfigClasses() {
        return new Class[] { WebAppInitializer.class };
    }

    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class[] { WebAppInitializer.class };
    }

    @Override
    protected String[] getServletMappings() {
        return new String[] { "/" };
    }

}
