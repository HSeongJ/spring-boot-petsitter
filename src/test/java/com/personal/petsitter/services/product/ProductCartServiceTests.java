package com.personal.petsitter.services.product;

import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@Log4j2
public class ProductCartServiceTests {

    @Autowired
    private ProductCartService service;

    @Test
    public void testAddCart() {
        log.info(service.addCart(1L, 1L));
    }

    @Test
    public void testGetCartList() {
        log.info(service.getCartList(1L));
    }
}
