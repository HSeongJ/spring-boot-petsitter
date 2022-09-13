package com.personal.petsitter.services.customer;

import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@Log4j2
public class CustomerServiceTests {

    @Autowired
    private CustomerService service;

    @Test
    public void testGetCustomerInfo() {
        log.info(service.getCustomerInfo(1L));
    }
}
