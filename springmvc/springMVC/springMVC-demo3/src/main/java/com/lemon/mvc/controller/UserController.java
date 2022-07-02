package com.lemon.mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @Classname UserController
 * @Description TODO
 * @Date 2022/7/1 18:58
 * @Created yj
 */
@Controller
public class UserController {

    @RequestMapping(value = "/user", method = RequestMethod.GET)
    public String getAllUser() {
        System.out.println("查询所有用户信息");
        return "success";
    }

    @RequestMapping(value = "/user/{id}", method = RequestMethod.GET)
    public String getUserById() {
        System.out.println("根据 ID 查询用户信息");
        return "success";
    }

    @RequestMapping(value = "/user", method = RequestMethod.POST)
    public String insertUser(String username, String password) {
//        System.out.println("添加用户信息");
        System.out.println("username=" + username + ", password=" + password);
        return "success";
    }

    @RequestMapping(value = "/user", method = RequestMethod.PUT)
    public String updateUser(String username, String password) {
        System.out.println("修改用户信息");
        System.out.println("username=" + username + ", password=" + password);
        return "success";
    }
}
