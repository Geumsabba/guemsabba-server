package com.example.geumsabba.service;

import com.example.geumsabba.entity.Newsletter;
import com.example.geumsabba.repository.NewsletterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class NewsletterService {

    private final NewsletterRepository newsletterRepository;

    @Autowired
    public NewsletterService(NewsletterRepository newsletterRepository) {
        this.newsletterRepository = newsletterRepository;
    }

    public void newsletterCreate(Newsletter newsletter){  //뉴스레터 생성

        newsletterRepository.save(newsletter);
    }
    public void newsletterDelete(Long id){  //뉴스레터 삭제

        newsletterRepository.deleteById(id);
    }
    public Newsletter newsletterGet(Long id){  //특정 뉴스레터 불러오기

        return newsletterRepository.findById(id).orElse(null);
    }

    public List<Newsletter> getAllNewsletters() {  //모든 뉴스레터 불러오기
        return newsletterRepository.findAll();
    }

    public List<Newsletter> searchByKeyword(String keyword) {
        List<Newsletter> allNewsletters = newsletterRepository.findAll();

        return allNewsletters.stream()
                .filter(newsletter -> newsletter.getTitle().contains(keyword))
                .collect(Collectors.toList());
    }

    /*public Page<Newsletter> newsletterList(Pageable pageable){ //뉴스레터 페이지 처리

        return newsletterRepository.findAll(pageable);
    }
    public Page<Newsletter> newsletterSearchList(String searchKeyword, Pageable pageable){

        return newsletterRepository.findByTitleContaining(searchKeyword, pageable);
    }*/
}
