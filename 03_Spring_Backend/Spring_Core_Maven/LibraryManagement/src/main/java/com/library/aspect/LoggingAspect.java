package com.library.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.After;

@Aspect
public class LoggingAspect {

    @Before("execution(* com.library.service.BookService.*(..))")
    public void logBeforeMethod() {
        System.out.println("[AOP LOG] Before executing BookService method.");
    }

    @After("execution(* com.library.service.BookService.*(..))")
    public void logAfterMethod() {
        System.out.println("[AOP LOG] After executing BookService method.");
    }
}