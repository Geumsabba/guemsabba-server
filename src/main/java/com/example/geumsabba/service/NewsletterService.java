package com.example.geumsabba.service;

import com.example.geumsabba.newsletter.Newsletter;
import com.example.geumsabba.repository.NewsletterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

        return newsletterRepository.findById(id).get();
    }
}
