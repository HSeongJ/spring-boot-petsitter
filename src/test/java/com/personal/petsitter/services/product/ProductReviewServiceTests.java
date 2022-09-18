package com.personal.petsitter.services.product;


import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@Log4j2
public class ProductReviewServiceTests {

    @Autowired
    public ProductReviewService service;

    @Test
    public void testGetReview() {
        log.info(service.getReview(1L, 1));
    }
}
