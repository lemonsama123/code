package com.lemon.mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Arrays;

/**
 * @Classname ParamController
 * @Description TODO
 * @Date 2022/6/30 21:57
 * @Created by yj
 */
@Controller
public class ParamController {

    @RequestMapping("/testServletAPI")
    public String testServletAPI(HttpServletRequest request) {
        HttpSession session = request.getSession();
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        System.out.println("username:" + username + ", password:" + password);
        return "success";
    }

    @RequestMapping("/testParam")
    public String testParam(@RequestParam(value = "user_name", required = false, defaultValue = "hehe") String username, String password, String[] bobby, @RequestHeader("Host") String host,
                            @CookieValue("JSESSIONID") String jsessionid) {
        System.out.println("username:" + username + ", password:" + password + ", hobby:" + Arrays.toString(bobby) + ", Host:" + host + ", Jsessionid:" + jsessionid);
        return "success";
    }
}
