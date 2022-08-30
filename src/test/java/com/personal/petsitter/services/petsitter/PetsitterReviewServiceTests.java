package com.personal.petsitter.services.petsitter;

import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@Log4j2
public class PetsitterReviewServiceTests {

    @Autowired
    private PetsitterReviewService petsitterReviewService;

    @Test
    public void testGetReviewList() {
        log.info(petsitterReviewService.getPetsitterReview(1L, 1));
    }
}
