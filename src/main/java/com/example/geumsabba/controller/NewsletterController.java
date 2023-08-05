package com.example.geumsabba.controller;


import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("geumsabba")
public class NewsletterController {


    @GetMapping("newsletter/view")
    public String boardView(Model model, Integer id){

        //model.addAttribute("newsletter", newsletterService.newsletterView(id));

        return "newsletterview";
    }
}
