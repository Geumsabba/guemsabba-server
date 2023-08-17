package com.example.geumsabba.controller;


import com.example.geumsabba.entity.Newsletter;
import com.example.geumsabba.entity.NewsletterResponse;
import com.example.geumsabba.service.NewsletterService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;

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

    @CrossOrigin(origins = {"http://localhost:3000", "https://geumsabba.store/"})
    @PostMapping("/newsletter/create")
    @ResponseStatus(HttpStatus.CREATED)
    public void createNewsletter(@RequestBody Newsletter newsletter) {
        newsletterService.newsletterCreate(newsletter);
    }

    @CrossOrigin(origins = {"http://localhost:3000", "https://geumsabba.store/"})
    @DeleteMapping("/newsletter/delete/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteNewsletter(@PathVariable Long id) {
        newsletterService.newsletterDelete(id);
    }

    @CrossOrigin(origins = {"http://localhost:3000", "https://geumsabba.store/"})
    @GetMapping("/newsletter/search")  //특정 keyword로 검색하기
    public ResponseEntity<List<Newsletter>> searchNewslettersByKeyword(@RequestParam String keyword) {
        List<Newsletter> newsletters = newsletterService.searchByKeyword(keyword);

        if (!newsletters.isEmpty()) {
            return new ResponseEntity<>(newsletters, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    ///////////////////////////////////////
    @CrossOrigin(origins = {"http://localhost:3000", "https://geumsabba.store/"})
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


    @CrossOrigin(origins = {"http://localhost:3000", "https://geumsabba.store/"})
    @GetMapping("/newsletter/getone/{id}")
    public ResponseEntity<NewsletterResponse> getNewsletterById(@PathVariable Long id) {
        Newsletter newsletter = newsletterService.newsletterGet(id);

        NewsletterResponse response = new NewsletterResponse(newsletter.getDate(), newsletter.getEditor(), newsletter.getTitle(),
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

        if (newsletter != null) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }


    /*@GetMapping("/newsletter/create") //뉴스레터 생성
    public  String newsletterCreate(Newsletter newsletter){

        newsletterService.newsletterCreate(newsletter);

        return "redirect:/geumsabba";
    }

    @GetMapping("/newsletter/delete")
    public String newsletterDelete(Long id){

        newsletterService.newsletterDelete(id);

        return "redirect:/geumsabba";
    }*/
}
