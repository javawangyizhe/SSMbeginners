package com.offcn.controller;

import com.offcn.pojo.User;
import com.offcn.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

@Controller
public class LoginController {
    @Autowired
    private UserService userService;
    @RequestMapping("/login")
    public String login(User user, HttpSession session){
        User user1 = userService.findUserByUser(user);
        if(user1 != null){
            session.setAttribute("user",user1);
            session.setAttribute("msg","用户名或密码错误");
            return "redirect:index.jsp";
        }else{
            return "redirect:login.jsp";
        }
    }

}
