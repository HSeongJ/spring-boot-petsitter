package com.personal.petsitter.repositories.product;

import com.personal.petsitter.entities.customer.CustomerEntity;
import com.personal.petsitter.entities.product.ProductCartEntity;
import com.personal.petsitter.entities.product.ProductEntity;
import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.transaction.Transactional;
import java.util.stream.IntStream;

@SpringBootTest
@Log4j2
public class ProductCartRepositoryTests {

    @Autowired
    private ProductCartRepository repository;

    @Test
    public void InsertDummies() {
        IntStream.rangeClosed(1, 300).forEach(i -> {
            ProductCartEntity entity = ProductCartEntity.builder()
                    .customer(CustomerEntity.builder().idx((long)(Math.random() * 20) + 1).build())
                    .product(ProductEntity.builder().idx((long)(Math.random() * 100) + 1).build())
                    .build();

            repository.save(entity);
        });
    }

    @Test
    public void testAddCart() {
        ProductCartEntity entity = ProductCartEntity.builder()
                .customer(CustomerEntity.builder().idx(1L).build())
                .product(ProductEntity.builder().idx(1L).build())
                .build();

        repository.save(entity);
    }

    @Test
    public void testGetCartList() {
        log.info(repository.getCartListInfo(1L));
    }
}
