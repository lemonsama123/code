package com.lemon.mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Map;

/**
 * @Classname ScopeController
 * @Description TODO
 * @Date 2022/7/1 12:37
 * @Created yj
 */
@Controller
public class ScopeController {

    @RequestMapping("/testRequstByServletAPI")
    public String testRequstByServletAPI(HttpServletRequest request) {
        request.setAttribute("testRequestScope", "hello, servletAPI");
        return "success";
    }

    @RequestMapping("/testModelAndView")
    public ModelAndView testModelAndView() {
        ModelAndView mav = new ModelAndView();
        mav.addObject("testRequestScope", "hello, ModelAndView");
        mav.setViewName("success");
        return mav;
    }

    @RequestMapping("/testModel")
    public String testModel(Model model) {
        model.addAttribute("testRequestScope", "hello, model");
        return "success";
    }

    @RequestMapping("/testMap")
    public String testMap(Map<String, Object> map) {
        map.put("testRequestScope", "hello, map");
        return "success";
    }

    @RequestMapping("/testModelMap")
    public String testModelMap(ModelMap modelMap) {
        modelMap.addAttribute("testRequestScope", "hello, modelMap");
        return "success";
    }

    @RequestMapping("/testSession")
    public String testSession(HttpSession session) {
        session.setAttribute("testSessionScope", "hello, session");
        return "success";
    }

    @RequestMapping("/testApplication")
    public String testApplication(HttpSession session) {
        ServletContext servletContext = session.getServletContext();
        servletContext.setAttribute("testApplicationScope", "hello, application");
        return "success";
    }
}
