package com.example.geumsabba;

import com.example.geumsabba.entity.Newsletter;
import com.example.geumsabba.repository.NewsletterRepository;
import com.example.geumsabba.service.NewsletterService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import java.util.Optional;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class NewsletterServiceTest {

    @Mock
    private NewsletterRepository newsletterRepository;

    private NewsletterService newsletterService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this); // 목 객체 초기화
        newsletterService = new NewsletterService(newsletterRepository);
    }

    @Test
    public void testNewsletterCreate() {
        Newsletter newsletter = new Newsletter();

        newsletterService.newsletterCreate(newsletter);

        verify(newsletterRepository, times(1)).save(newsletter);
    }

    @Test
    public void testNewsletterDelete() {
        Long idToDelete = 1L;

        newsletterService.newsletterDelete(idToDelete);

        verify(newsletterRepository, times(1)).deleteById(idToDelete);
    }

    @Test
    public void testNewsletterGet() {
        Long idToGet = 1L;
        Newsletter mockNewsletter = new Newsletter();
        when(newsletterRepository.findById(idToGet)).thenReturn(Optional.of(mockNewsletter));

        Newsletter retrievedNewsletter = newsletterService.newsletterGet(idToGet);

        assertNotNull(retrievedNewsletter);
        assertSame(mockNewsletter, retrievedNewsletter);
    }

}
