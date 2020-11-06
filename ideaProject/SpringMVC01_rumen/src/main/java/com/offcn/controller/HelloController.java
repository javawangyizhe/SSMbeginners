package com.offcn.controller;

import com.offcn.pojo.Customer;
import com.offcn.pojo.Orders;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
public class HelloController {
    @RequestMapping("helloController")
    public ModelAndView hello(Customer customer){
        System.out.println(customer);
        ModelAndView mav = new ModelAndView();
        mav.setViewName("success");
        return mav;
    }
    @RequestMapping("helloController2")
    public ModelAndView hello2(Orders orders){
        System.out.println(orders);
        ModelAndView mav = new ModelAndView();
        mav.setViewName("success");
        return mav;
    }
    @RequestMapping("helloController3")
    public String hello3(HttpServletRequest request, HttpServletResponse response){
        System.out.println("1");
        return "forward:/helloController2";
    }
}
