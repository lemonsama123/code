package com.lemon.mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
//@RequestMapping("/hello")
public class RequestMappingController {

    @RequestMapping(
            value =  {"/testRequestMapping", "/test"},
            method = {RequestMethod.POST, RequestMethod.GET},
            params = {"username"}
    )
    public String success() {
        return "success";
    }

    @GetMapping("/testGetMapping")
    public String testGetMapping() {
        return "success";
    }

    @RequestMapping(value = "/testPut", method = RequestMethod.PUT)
    public String testPut() {
        return "success";
    }

    @RequestMapping(
            value = "/testParamsAndHeaders",
            params = {"username","password!=123456"},
            headers = {"header"}
    )
    public String testParamsAndHeaders() {
        return "success";
    }

    @RequestMapping("/**/testAnt")
    public String testAnt() {
        return "success";
    }
}
