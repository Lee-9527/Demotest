package com.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/home")
public class VisitController {

    //首页跳转到地图页
    @RequestMapping("/map.action")
    public String mapPage() {

        return "/WEB-INF/jsp/Basic.jsp";
    }

    //首页跳转到登录页面
    @RequestMapping("/userLogin.action")
    public String loginPage() {

        return "/WEB-INF/jsp/UserLogin.jsp";
    }



}
