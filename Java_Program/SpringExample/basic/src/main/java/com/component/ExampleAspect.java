package com.component;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import org.aspectj.lang.annotation.Aspect;
/**
 * Created by nikhil on 26/1/18.
 */
@Aspect
@Component
public class ExampleAspect {

    @Around("execution(* getMessage(..))")
    public Object logExecutionTime(ProceedingJoinPoint joinPoint) throws Throwable {
        System.out.println("Around method is called ...");
        final long start = System.currentTimeMillis();

        final Object proceed = joinPoint.proceed();
         final long executionTime = System.currentTimeMillis() - start;

        System.out.println(joinPoint.getSignature() + " executed in " + executionTime + "ms");
        System.out.println( " Around method exists ...");
        return proceed;
    }
    @Before("execution(public String getMessage())")
    public Object before( JoinPoint joinPoint) throws Throwable {

        System.out.println("Before pointcut...  "+joinPoint.getSignature() );

        return joinPoint;
    }

    @After("args(message)")
    public void logStringArguments(String message){
        System.out.println("Running After Advice. String argument passed="+message);
    }
    @AfterReturning(pointcut="execution(* getMessage(..))", returning="returnString")
    public void getNameReturningAdvice(String returnString){
        System.out.println("getNameReturningAdvice executed. Returned String="+returnString);
    }
}
