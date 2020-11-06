package com.offcn.controller;

import com.offcn.pojo.Card;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller

public class HelloController {

    @RequestMapping("/hello")
    public ModelAndView hello1(HttpServletRequest request, HttpServletResponse response,
                               HttpSession session){
        request.setAttribute("username","张三");
        ModelAndView mav = new ModelAndView();
        mav.setViewName("success");
        return mav;
    }
    @RequestMapping("/hello2")
    public ModelAndView hello2(Model model){
        model.addAttribute("username2","李四");
        ModelAndView mav = new ModelAndView();
        mav.setViewName("success");
        return mav;
    }
    @RequestMapping("/hello3")
    public ModelAndView hello3(Map map){
        System.out.println("转发操作");
        map.put("username3","王五");
        ModelAndView mav = new ModelAndView();
        mav.setViewName("success");
        return mav;
    }
    @RequestMapping("/hello4")
    public ModelAndView hello4(ModelMap map){
        System.out.println("重定向操作");
        map.addAttribute("username4","赵六");
        ModelAndView mav = new ModelAndView();
        mav.setViewName("success");
        return mav;
    }
    @RequestMapping("/hello5")
    public String hello5(Map map){
        return "redirect:/hello4";
    }
    @RequestMapping("/hello6")
    public String hello6(Map map){
        return "forward:/hello3";
    }
    @RequestMapping("/hello7")
    @ResponseBody
    public Card hello7(){
        Card card = new Card();
        card.setId(1);
        card.setName("zhangsan");
        card.setNum("123");
        return card;
    }
    @RequestMapping("/hello8")
    @ResponseBody
    public List<Card> hello8(){
        Card card = new Card();
        card.setId(1);
        card.setName("zhangsan");
        card.setNum("123");
        Card card2 = new Card();
        card2.setId(2);
        card2.setName("lisi");
        card2.setNum("456");
        List list = new ArrayList();
        list.add(card);
        list.add(card2);
        return list;
    }
    @RequestMapping("/hello9")
    @ResponseBody
    public Map<String,Card> hello9(){
        Card card = new Card();
        card.setId(1);
        card.setName("zhangsan");
        card.setNum("123");
        Card card2 = new Card();
        card2.setId(2);
        card2.setName("lisi");
        card2.setNum("456");
        Map map = new HashMap();
        map.put("card1",card);
        map.put("card2",card2);
        return map;
    }
    @RequestMapping("/hello10/{id}")
    public String hello10(@PathVariable("id") Integer id){
        System.out.println(id);
        return "success";
    }
    @RequestMapping(path = {"/hello11","/hello12"})
    public String hello11(@RequestBody String body){
        System.out.println(body);
        return "success";
    }


}
