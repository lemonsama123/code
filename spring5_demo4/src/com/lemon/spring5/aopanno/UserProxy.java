package com.lemon.spring5.aopanno;


import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class UserProxy {

    @Before(value = "execution(* com.lemon.spring5.aopanno.User.add(..))")
    public void before() {
        System.out.println("before......");
    }

    @AfterReturning(value = "execution(* com.lemon.spring5.aopanno.User.add(..))")
    public void afterReturning() {
        System.out.println("afterReturning......");
    }

    @AfterThrowing(value = "execution(* com.lemon.spring5.aopanno.User.add(..))")
    public void afterThrowing() {
        System.out.println("afterThrowing......");
    }

    @After(value = "execution(* com.lemon.spring5.aopanno.User.add(..))")
    public void after() {
        System.out.println("after......");
    }


    @Around(value = "execution(* com.lemon.spring5.aopanno.User.add(..))")
    public void around(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        System.out.println("around......之前");
        proceedingJoinPoint.proceed();
        System.out.println("around......之后");

    }
}
