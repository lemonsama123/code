package com.lemon.spring5.aopanno;


import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Aspect
@Order(3)
public class UserProxy {

    @Pointcut(value = "execution(* com.lemon.spring5.aopanno.User.add(..))")
    public void pointdemo() {

    }

    @Before(value = "pointdemo()")
    public void before() {
        System.out.println("before......");
    }

    @AfterReturning(value = "pointdemo()")
    public void afterReturning() {
        System.out.println("afterReturning......");
    }

    @AfterThrowing(value = "pointdemo()")
    public void afterThrowing() {
        System.out.println("afterThrowing......");
    }

    @After(value = "pointdemo()")
    public void after() {
        System.out.println("after......");
    }


    @Around(value = "pointdemo()")
    public void around(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        System.out.println("around......之前");
        proceedingJoinPoint.proceed();
        System.out.println("around......之后");

    }
}
