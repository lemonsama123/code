package com.lemon.boot.controller;

import com.lemon.boot.bean.Car;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Classname HelloController
 * @Description TODO
 * @Date 2022/7/4 12:26
 * @Created yj
 */
//@Controller
//@ResponseBody

@Slf4j
@RestController
public class HelloController {

    @Autowired
    Car car;

    @RequestMapping("/hello")
    public String handle01() {
        log.info("请求进来了");
        return "Hello, Sprint Boot 2!" + "你好，" + "胡宇婷";
    }

    @RequestMapping("/car")
    public Car car() {

        return car;
    }
}
