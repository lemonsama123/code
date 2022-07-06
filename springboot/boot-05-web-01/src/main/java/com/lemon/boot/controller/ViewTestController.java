package com.lemon.boot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @Classname ViewTestController
 * @Description TODO
 * @Date 2022/7/6 13:18
 * @Created yj
 */
@Controller
public class ViewTestController {

    @GetMapping("/hello")
    public String lemon(Model model) {
        model.addAttribute("msg", "你好，lemon");
        model.addAttribute("link", "http://www.baidu.com");
        return "success";
    }
}
