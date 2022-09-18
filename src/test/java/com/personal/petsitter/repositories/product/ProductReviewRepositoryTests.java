package com.personal.petsitter.repositories.product;

import com.personal.petsitter.entities.product.ProductEntity;
import com.personal.petsitter.entities.product.ProductReviewEntity;
import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.stream.IntStream;

@SpringBootTest
@Log4j2
public class ProductReviewRepositoryTests {

    @Autowired
    private ProductReviewRepository repository;

    @Test
    public void insertDummies() {
        IntStream.rangeClosed(1, 1000).forEach(i -> {
            ProductReviewEntity entity = ProductReviewEntity.builder()
                    .reviewWriter(i % 20 + 1L)
                    .title("testTitle" + i)
                    .content("testContent" + i)
                    .rated(Math.random() * 5)
                    .product(ProductEntity.builder().idx(i % 30 + 1L).build())
                    .picture1("testPicture1" + i)
                    .picture2("testPicture2" + i)
                    .picture3("testPicture3" + i)
                    .picture4("testPicture4" + i)
                    .picture5("testPicture5" + i)
                    .build();

            repository.save(entity);
        });
    }

    @Test
    public void testGetReview() {
        log.info(repository.getReviewList(1L, 1));
    }
}
