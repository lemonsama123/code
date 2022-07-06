package com.lemon.admin.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @Classname TableController
 * @Description TODO
 * @Date 2022/7/6 14:25
 * @Created yj
 */
@Controller
public class TableController {

    @GetMapping("/basic_table")
    public String basic_table() {
        return "/table/basic_table";
    }

    @GetMapping("/dynamic_table")
    public String dynamic_table() {
        return "/table/dynamic_table";
    }

    @GetMapping("/responsive_table")
    public String responsive_table() {
        return "/table/responsive_table";
    }

    @GetMapping("/editable_table")
    public String editable_table() {
        return "/table/editable_table";
    }
}
