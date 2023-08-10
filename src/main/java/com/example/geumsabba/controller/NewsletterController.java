package com.example.geumsabba.controller;


import com.example.geumsabba.newsletter.Newsletter;
import com.example.geumsabba.service.NewsletterService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
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

    @GetMapping("/newsletter/list")   //searchKeyword를 포함하고 있는 뉴스레터 찾기
    public String boardList(Model model,
                            @PageableDefault(page = 0, size = 6, sort = "id", direction = Sort.Direction.DESC ) Pageable pageable,
                            String searchKeyword){

        Page<Newsletter> list = null;

        if(searchKeyword == null){
            list = newsletterService.newsletterList(pageable);
        }else{
            list = newsletterService.newsletterSearchList(searchKeyword, pageable);
        }

        int nowPage = list.getPageable().getPageNumber() + 1;
        int startPage = Math.max(nowPage - 4, 1);
        int endPage = Math.min(nowPage + 5, list.getTotalPages());

        model.addAttribute("list",list);
        model.addAttribute("nowPage",nowPage);
        model.addAttribute("startPage",startPage);
        model.addAttribute("endPage",endPage);

        return "newsletterlist";
    }

}
