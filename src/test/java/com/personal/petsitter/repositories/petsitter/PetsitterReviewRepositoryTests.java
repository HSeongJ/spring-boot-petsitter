package com.personal.petsitter.repositories.petsitter;


import com.personal.petsitter.entities.petsitter.PetsitterEntity;
import com.personal.petsitter.entities.petsitter.PetsitterReviewEntity;
import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.stream.IntStream;

@SpringBootTest
@Log4j2
public class PetsitterReviewRepositoryTests {

    @Autowired
    private PetsitterReviewRepository repository;

    @Test
    public void InsertDummies() {
        IntStream.rangeClosed(1, 1000).forEach(i -> {
            PetsitterReviewEntity entity = PetsitterReviewEntity.builder()
                    .reviewWriter(i % 20 + 1L)
                    .title("TestTitle" + i)
                    .content("TestContent" + i)
                    .rated(Math.random() * 5)
                    .petsitter(PetsitterEntity.builder().idx(((long)(Math.random() * 20) + 1)).build()).build();

            repository.save(entity);
        });
    }
}
