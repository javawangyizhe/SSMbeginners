package com.offcn.controller;

import com.offcn.pojo.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

@Controller
public class LoginController {
    @RequestMapping("/login")
    public String login(User user, HttpSession session){
        if("admin".equals(user.getUsername()) && "admin".equals(user.getPassword())){
            session.setAttribute("user",user);
            return "redirect:indexInfo";
        }else{
            return "redirect:login.jsp";
        }
    }

    @RequestMapping("indexInfo")
    public String info(Model model){
        model.addAttribute("money","1200000");
        return "success";
    }
}
