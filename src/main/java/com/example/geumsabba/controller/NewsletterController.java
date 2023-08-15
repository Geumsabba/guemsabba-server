package com.example.geumsabba.controller;


import com.example.geumsabba.entity.Newsletter;
import com.example.geumsabba.entity.NewsletterResponse;
import com.example.geumsabba.service.NewsletterService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("geumsabba")
public class NewsletterController {

    private final NewsletterService newsletterService;

    public NewsletterController(NewsletterService newsletterService) {
        this.newsletterService = newsletterService;
    }


    @GetMapping("/newsletter/create") //뉴스레터 생성
    public  String newsletterCreate(Newsletter newsletter){

        newsletterService.newsletterCreate(newsletter);

        return "redirect:/geumsabba";
    }

    @GetMapping("/newsletter/delete")
    public String newsletterDelete(Long id){

        newsletterService.newsletterDelete(id);

        return "redirect:/geumsabba";
    }

    @GetMapping("/newsletter/keyword")   //searchKeyword를 포함하고 있는 뉴스레터 찾기
    public String newsletterList(Model model,
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

    ///////////////////////////////////////
    @GetMapping("/newsletter/getall")  // 뉴스레터 전부 불러오기
    public ResponseEntity<List<NewsletterResponse>> newsletterGetAll() {
        List<Newsletter> newsletters = newsletterService.getAllNewsletters();

        List<NewsletterResponse> responseList = newsletters.stream()
                .map(newsletter -> {
                    NewsletterResponse response = new NewsletterResponse(
                            newsletter.getDate(), newsletter.getEditor(), newsletter.getTitle(),
                            newsletter.getHeader(), newsletter.getSubtitle1(), newsletter.getSubtitle2(),
                            newsletter.getSubtitle3(), newsletter.getContent1(), newsletter.getContent2(),
                            newsletter.getContent3());

                    try {
                        Resource resource1 = new ClassPathResource(newsletter.getImage1());
                        Resource resource2 = new ClassPathResource(newsletter.getImage2());
                        Resource resource3 = new ClassPathResource(newsletter.getImage3());

                        InputStream inputStream1 = resource1.getInputStream();
                        InputStream inputStream2 = resource2.getInputStream();
                        InputStream inputStream3 = resource3.getInputStream();

                        byte[] image1Bytes = inputStream1.readAllBytes();
                        byte[] image2Bytes = inputStream2.readAllBytes();
                        byte[] image3Bytes = inputStream3.readAllBytes();

                        response.setImage1(image1Bytes);
                        response.setImage2(image2Bytes);
                        response.setImage3(image3Bytes);
                    } catch (IOException e) {
                        // Handle the exception
                    }

                    return response;
                })
                .collect(Collectors.toList());

        return ResponseEntity.ok(responseList);
    }


    @GetMapping("/newsletter/getone")  //id로 특정 뉴스레터 불러오기
    public String newsletterGet(Model model, Long id){

        model.addAttribute("newsletter", newsletterService.newsletterGet(id));

        return "newsletterget";
    }

}
