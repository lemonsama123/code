package com.lemon.spring5.aopxml;

import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

public class BookProxy {


    public void before() {
        System.out.println("before......");
    }
}
