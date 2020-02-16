package com.demo.controller;

import com.demo.service.UserService;
import com.demo.util.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/new")
public class LoginController {

    @Autowired
    private UserService userService;

    //登录
    @RequestMapping("/LoginIn.action")
    @ResponseBody
    public Message userLogin(String username, String password, String verifyCode, HttpServletRequest request) throws Exception {
        HttpSession session = request.getSession();
        Message message = new Message();

        String code = (String) session.getAttribute("safecode");
        if (!verifyCode.equals(code)){
            message.setMsg("验证码错误");
            /*model.addAttribute("message", message);*/
            message.setState(-1);
           return  message;
        }

        message = userService.checkUser(username,password);

        System.out.print(message);

        //model.addAttribute("message", message);

        return message;
    }

}
