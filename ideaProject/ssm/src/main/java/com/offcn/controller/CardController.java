package com.offcn.controller;

import com.offcn.pojo.Card;
import com.offcn.service.CardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class CardController {
    @Autowired
    private CardService cardService;
    @RequestMapping("/findCardById")
    public String findCardById(Integer id, Model model){
        System.out.println(id);
        Card card = cardService.findCardByIdService(id);
        model.addAttribute("card",card);
        return "success";
    }

}
