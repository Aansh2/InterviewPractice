package com.component;

import com.model.Animal;
import com.annotation.CatType;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.lang.annotation.Annotation;

/**
 * Created by nikhil on 15/1/18.
 */

@Component
@CatType
public class Cat extends Animal{
    @Override

    public String toString() {
        return "Cat {}";
    }


}
