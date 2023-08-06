package com.example.geumsabba.controller;


import com.example.geumsabba.newsletter.Newsletter;
import com.example.geumsabba.service.NewsletterService;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("geumsabba")
public class NewsletterController {

    private final NewsletterService newsletterService;

    public NewsletterController(NewsletterService newsletterService) {
        this.newsletterService = newsletterService;
    }

    @GetMapping("/newsletter/get")  //특정 뉴스레터 불러오기
    public String newsletterGet(Model model, Long id){

        model.addAttribute("newsletter", newsletterService.newsletterGet(id));

        return "newsletterget";
    }

    @GetMapping("/newsletter/create") //뉴스레터 생성
    public  String newsletterCreate(Newsletter newsletter){

        newsletterService.newsletterCreate(newsletter);

        return "redirect:/geumsabba";
    }

    @GetMapping("/newsletter/delete")
    public String boardDelete(Long id){

        newsletterService.newsletterDelete(id);

        return "redirect:/geumsabba";
    }

}
