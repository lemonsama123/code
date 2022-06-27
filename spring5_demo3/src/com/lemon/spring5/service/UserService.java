package com.lemon.spring5.service;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;

@Controller(value = "userService")
public class UserService {

    public void add() {
        System.out.println("service add......");
    }
}
