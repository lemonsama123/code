package com.lemon.mvc.controller;

import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Classname JspController
 * @Description TODO
 * @Date 2022/7/1 17:13
 * @Created yj
 */
public class JspController {

    @RequestMapping("/success")
    public String success() {
        return "success";
    }
}
