package com.lemon.mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Classname ViewController
 * @Description TODO
 * @Date 2022/7/1 15:06
 * @Created yj
 */
@Controller
public class ViewController {

    @RequestMapping("/testThymeleafView")
    public String testThymeleafView() {
        return "success";
    }

    @RequestMapping("testForward")
    public String testForward() {
        return "forward:/testThymeleafView";
    }

    @RequestMapping("/testRedirect")
    public String testRedirect() {
        return "redirect:/testThymeleafView";
    }
}

