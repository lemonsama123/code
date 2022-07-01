package com.lemon.mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Classname TestController
 * @Description TODO
 * @Date 2022/7/1 12:28
 * @Created by yj
 */
@Controller
public class TestController {

//    @RequestMapping("/")
//    public String index() {
//        return "index";
//    }

    @RequestMapping("/test_view")
    public String testView() {
        return "test_view";
    }
}
