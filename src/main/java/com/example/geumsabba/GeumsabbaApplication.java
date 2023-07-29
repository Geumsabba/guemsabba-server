package com.example.geumsabba;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class GeumsabbaApplication {

    public static void main(String[] args) {
        SpringApplication.run(GeumsabbaApplication.class, args);
    }

}
