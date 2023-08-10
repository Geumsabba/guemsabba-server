package com.example.geumsabba.repository;

import com.example.geumsabba.newsletter.Newsletter;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NewsletterRepository extends JpaRepository<Newsletter, Long> {

    Page <Newsletter> findByTitleContaining(String searchKeyword, Pageable pageable);
}
