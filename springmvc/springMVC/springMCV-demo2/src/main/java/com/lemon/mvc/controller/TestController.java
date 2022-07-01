package com.lemon.mvc.controller;

import com.lemon.mvc.bean.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class TestController {

    @RequestMapping("/")
    public String index() {
        return "index";
    }

    @RequestMapping("/param")
    public String param() {
        return "test_param";
    }

    @RequestMapping("/testBean")
    public String testBean(User user) {
        System.out.println(user);

        return "success";
    }
}
