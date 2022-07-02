package com.lemon.mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Classname TestController
 * @Description TODO
 * @Date 2022/7/2 18:34
 * @Created yj
 */
@Controller
public class TestController {

    @RequestMapping("/")
    public String index() {
        return "index";
    }
}
