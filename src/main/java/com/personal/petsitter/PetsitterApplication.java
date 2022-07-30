package com.personal.petsitter;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class PetsitterApplication {

    public static void main(String[] args) {
        SpringApplication.run(PetsitterApplication.class, args);
    }

}
