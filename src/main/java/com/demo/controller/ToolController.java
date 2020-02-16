package com.demo.controller;

import com.demo.service.VerifyimageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Controller
@RequestMapping("/tool")
public class ToolController {

    @Autowired
    private VerifyimageService verifyimageService;


    //验证码获取
    @RequestMapping("/verifyimage.action")
    public void verifyimage(HttpServletRequest request, HttpServletResponse response) throws IOException {

        verifyimageService.getVerifyimage(request,response);

    }
}
